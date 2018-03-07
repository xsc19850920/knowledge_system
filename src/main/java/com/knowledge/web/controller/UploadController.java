package com.knowledge.web.controller;


import com.aliyun.oss.OSSClient;
import com.knowledge.web.config.OSSConfig;
import com.knowledge.web.util.AliyunOSSClientUtil;
import org.apache.http.HttpException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UploadController {
    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     *
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) {
        if (!file.isEmpty()) {
                //初始化OSSClient
                OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
                //上传文件
                File filess=MultipartFileToFile(file);
                String md5key = AliyunOSSClientUtil.uploadObject2OSS(ossClient, filess, OSSConfig.BACKET_NAME, OSSConfig.FOLDER);
                String fileURL = AliyunOSSClientUtil.getUrl("knowledge/"+filess.getName());
                return "{\"url\":\""+fileURL+"\",\"key\":\"knowledge/"+filess.getName()+"\"}";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    @RequestMapping(value = "/deletefile", method = RequestMethod.GET)
    @ResponseBody
    public String deletefile(@RequestParam(value="key") String key) {
        if (!key.isEmpty()) {
            //初始化OSSClient
            OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
            AliyunOSSClientUtil.deleteFile(ossClient, OSSConfig.BACKET_NAME,OSSConfig.FOLDER,key);
            return "OK";
        } else {
            return "上传失败，因为文件是空的.";
        }
    }

    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     *
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody String batchUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for(MultipartFile file:files){
            //初始化OSSClient
            OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
            //上传文件
            File filess=MultipartFileToFile(file);
            String md5key = AliyunOSSClientUtil.uploadObject2OSS(ossClient, filess, OSSConfig.BACKET_NAME, OSSConfig.FOLDER);
            AliyunOSSClientUtil.getUrl("knowledge/"+filess.getName());
        }

        return "OK";
    }

    private File MultipartFileToFile(MultipartFile file){
        File f = null;
        String fileName = file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        try {
            f=File.createTempFile("tmp", suffix);
            file.transferTo(f);
            f.deleteOnExit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
