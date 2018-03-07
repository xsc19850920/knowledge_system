package com.knowledge.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.dao.InfoFileDao;
import com.knowledge.web.dao.InfoListenDao;
import com.knowledge.web.dao.ReviewDao;
import com.knowledge.web.domain.InfoFile;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.Review;
import com.knowledge.web.util.IPUtil;
import com.knowledge.web.util.PageInfo;
import com.knowledge.web.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Controller
@RequestMapping("/")
public class InfoListenController {

    @Autowired
    private InfoListenDao infoListenDao;

    @Autowired
    private InfoFileDao infoFileDao;

    @RequestMapping(value = "/getInfoListens",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<InfoListen> getInfoListens(String keywords, int pageNo, int pageSize,Integer categoryId) throws Exception {
        Page<InfoListen> infoListens = infoListenDao.getInfoListens(pageNo, pageSize,keywords,categoryId);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<InfoListen> pageInfo = new PageInfo<InfoListen>(infoListens);
        return pageInfo;
    }

    @RequestMapping(value = "/deleteInfoListen",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteInfoListen(@RequestParam(value="id") BigInteger id) throws Exception {
        infoListenDao.deleteInfoListen(id);
        return true;
    }
    
    @RequestMapping(value = "/updateListennNewSign",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateListennNewSign(@RequestParam(value="id") BigInteger id) throws Exception {
        infoListenDao.updateListennNewSign(id);
        return true;
    }

    @RequestMapping(value = "/insertInfoListen",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertInfoListen(String title,String fileSrc,Integer stateType,String operIp
            ,BigInteger operUserId,Integer duration, Integer flagNew,Integer flagTop,Integer categoryId) throws Exception {
        InfoListen infoListen = new InfoListen();
        BigInteger infoId = BigInteger.valueOf(System.currentTimeMillis());
        infoListen.setCreateTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoListen.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoListen.setOperIp(IPUtil.Ip2Int(operIp)<0?-IPUtil.Ip2Int(operIp):IPUtil.Ip2Int(operIp));
        infoListen.setOperUserId(operUserId);
        infoListen.setDelFlag(false);
        infoListen.setInfoId(infoId);
        infoListen.setCategoryId(categoryId);
        infoListen.setTitle(title);
        infoListen.setFlagNew(flagNew);
        infoListen.setFlagTop(flagTop);
        infoListen.setStateType(stateType);
        infoListenDao.insertInfoListen(infoListen);
        InfoFile infoFile = new InfoFile();
        infoFile.setInfoFileId(BigInteger.valueOf(System.currentTimeMillis()));
        infoFile.setInfoId(infoId);
        infoFile.setFileType(1);
        infoFile.setFileSrc(fileSrc);
        infoFile.setDuration(duration);
        infoFile.setTitle(title);
        infoFile.setDisplayOrder(1);
        infoFile.setDetail("");
        infoFile.setMemo("");
        infoFileDao.insertInfoFile(infoFile);
        return true;
    }

    @RequestMapping(value = "/getInfoListenById",method = RequestMethod.POST)
    @ResponseBody
    public InfoListen getInfoListenById(@RequestParam(value="id") BigInteger id) {
        return infoListenDao.getInfoListenById(id);
    }


    @RequestMapping(value = "/updateInfoListen",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfoListen(@RequestBody InfoListen infoListen) throws Exception {
        infoListen.setModifyTime(BigInteger.valueOf(TimeUtil.getCurrentTimeStamp()));
        infoListenDao.updateInfoListen(infoListen);
        InfoFile infoFile = infoListen.getInfoFile();
        infoFileDao.updateInfoFile(infoFile);
        return true;
    }

}
