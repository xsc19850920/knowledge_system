package com.knowledge.web.controller;

import com.github.pagehelper.Page;
import com.knowledge.web.dao.InfoFileDao;
import com.knowledge.web.dao.InfoListenDao;
import com.knowledge.web.dao.InfoReadDao;
import com.knowledge.web.domain.InfoFile;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.InfoRead;
import com.knowledge.web.util.IPUtil;
import com.knowledge.web.util.PageInfo;
import com.knowledge.web.util.TimeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Controller
@RequestMapping("/")
public class InfoReadController {
    @Autowired
    private InfoReadDao infoReadDao;

    @Autowired
    private InfoFileDao infoFileDao;

    @RequestMapping(value = "/getInfoReads",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<InfoRead> getInfoReads(String keywords, int pageNo, int pageSize) throws Exception {
        Page<InfoRead> infoReads = infoReadDao.getInfoReads(pageNo, pageSize,keywords);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<InfoRead> pageInfo = new PageInfo<InfoRead>(infoReads);
        return pageInfo;
    }

    @RequestMapping(value = "/deleteInfoRead",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteInfoRead(@RequestParam(value="id") BigInteger id) throws Exception {
        infoReadDao.deleteInfoRead(id);
        return true;
    }

    @RequestMapping(value = "/updateReadNewSign",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateReadNewSign(@RequestParam(value="id") BigInteger id) throws Exception {
        infoReadDao.updateReadNewSign(id);
        return true;
    }
    
    @RequestMapping(value = "/insertInfoRead",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertInfoRead(@RequestBody InfoRead infoRead) throws Exception {
        InfoRead iread = new InfoRead();
        BigInteger infoId = BigInteger.valueOf(System.currentTimeMillis());
        iread.setCreateTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        iread.setDelFlag(false);
        iread.setFlagNew(infoRead.getFlagNew());
        iread.setInfoDate(infoRead.getInfoDate());
        iread.setInfoId(infoId);
        iread.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        iread.setOperIp(IPUtil.Ip2Int(infoRead.getIp())<0?-IPUtil.Ip2Int(infoRead.getIp()):IPUtil.Ip2Int(infoRead.getIp()));
        iread.setOperUserId(infoRead.getOperUserId());
        iread.setStateType(infoRead.getStateType());
        iread.setTitle(infoRead.getTitle());
        infoReadDao.insertInfoRead(iread);
        List<InfoFile> infoFiles = infoRead.getInfoFiles();
        if(infoFiles!=null && infoFiles.size() >0){
            for(int i = 0;i< infoFiles.size();i++){
                InfoFile infoFile = infoFiles.get(i);
                infoFile.setMemo("");
                infoFile.setDisplayOrder(i+1);
                infoFile.setTitle(infoRead.getTitle());
                infoFile.setDuration(0);
                infoFile.setFileType(1);
                infoFile.setInfoId(infoId);
                infoFile.setInfoFileId(BigInteger.valueOf(System.currentTimeMillis()+i));
                infoFileDao.insertInfoFile(infoFile);
            }
        }
        return true;
    }

    @RequestMapping(value = "/getInfoReadById",method = RequestMethod.POST)
    @ResponseBody
    public InfoRead getInfoReadById(@RequestParam(value="id") BigInteger id) {
        return infoReadDao.getInfoReadById(id);
    }


    @RequestMapping(value = "/updateInfoRead",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfoRead(@RequestBody InfoRead infoRead) throws Exception {
        infoRead.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoReadDao.updateInfoRead(infoRead);
        List<InfoFile> infoFileList = infoRead.getInfoFiles();
        for(int i = 0;i<infoFileList.size();i++){
            infoFileDao.updateInfoFile(infoFileList.get(i));
        }
        return true;
    }

}
