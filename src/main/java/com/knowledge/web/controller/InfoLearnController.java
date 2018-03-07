package com.knowledge.web.controller;

import com.github.pagehelper.Page;
import com.knowledge.web.dao.InfoFileDao;
import com.knowledge.web.dao.InfoLearnDao;
import com.knowledge.web.dao.InfoListenDao;
import com.knowledge.web.domain.InfoFile;
import com.knowledge.web.domain.InfoLearn;
import com.knowledge.web.domain.InfoListen;
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
public class InfoLearnController {
    @Autowired
    private InfoLearnDao infoLearnDao;

    @Autowired
    private InfoFileDao infoFileDao;

    @RequestMapping(value = "/getInfoLearns",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<InfoLearn> getInfoLearns(String keywords, int pageNo, int pageSize) throws Exception {
        Page<InfoLearn> infoLearns = infoLearnDao.getInfoLearns(pageNo, pageSize,keywords);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<InfoLearn> pageInfo = new PageInfo<InfoLearn>(infoLearns);
        return pageInfo;
    }

    @RequestMapping(value = "/deleteInfoLearn",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteInfoLearn(@RequestParam(value="id") BigInteger id) throws Exception {
        infoLearnDao.deleteInfoLearn(id);
        return true;
    }
    
    
    @RequestMapping(value = "/insertInfoLearn",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertInfoLearn(String infoDate,String title,String title1,String fileSrc,String fileSrc1,Integer stateType,String operIp
            ,BigInteger operUserId,Integer duration,Integer duration1,String detail,String detail1) throws Exception {
        InfoLearn infoLearn = new InfoLearn();
        BigInteger infoId = BigInteger.valueOf(System.currentTimeMillis());
        infoLearn.setCreateTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoLearn.setDelFlag(false);
        infoLearn.setInfoDate(infoDate);
        infoLearn.setInfoId(infoId);
        infoLearn.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoLearn.setOperIp(IPUtil.Ip2Int(operIp)<0?-IPUtil.Ip2Int(operIp):IPUtil.Ip2Int(operIp));
        infoLearn.setOperUserId(operUserId);
        infoLearn.setStateType(stateType);
        infoLearn.setTitle(title+"|"+title1);
        infoLearnDao.insertInfoLearn(infoLearn);
        InfoFile infoFile = new InfoFile();
        infoFile.setInfoFileId(BigInteger.valueOf(System.currentTimeMillis()));
        infoFile.setInfoId(infoId);
        infoFile.setFileType(1);
        infoFile.setFileSrc(fileSrc);
        infoFile.setDuration(duration);
        infoFile.setTitle(title);
        infoFile.setDisplayOrder(1);
        infoFile.setDetail(detail);
        infoFile.setMemo("");
        infoFileDao.insertInfoFile(infoFile);
        InfoFile infoFile1 = new InfoFile();
        infoFile1.setInfoFileId(BigInteger.valueOf(System.currentTimeMillis()+1));
        infoFile1.setInfoId(infoId);
        infoFile1.setFileType(1);
        infoFile1.setFileSrc(fileSrc1);
        infoFile1.setDuration(duration1);
        infoFile1.setTitle(title1);
        infoFile1.setDisplayOrder(2);
        infoFile1.setDetail(detail1);
        infoFile1.setMemo("");
        infoFileDao.insertInfoFile(infoFile1);
        return true;
    }

    @RequestMapping(value = "/getInfoLearnById",method = RequestMethod.POST)
    @ResponseBody
    public InfoLearn getInfoLearnById(@RequestParam(value="id") BigInteger id) {
        return infoLearnDao.getInfoLearnById(id);
    }


    @RequestMapping(value = "/updateInfoLearn",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfoLearn(@RequestBody InfoLearn infoLearn) throws Exception {
        infoLearn.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoLearnDao.updateInfoLearn(infoLearn);
        List<InfoFile> infoFileList = infoLearn.getInfoFiles();
        for(int i = 0;i<infoFileList.size();i++){
           infoFileDao.updateInfoFile(infoFileList.get(i));
        }
        return true;
    }
}
