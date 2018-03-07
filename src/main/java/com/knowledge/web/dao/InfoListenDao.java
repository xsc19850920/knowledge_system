package com.knowledge.web.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.Review;
import com.knowledge.web.mapper.InfoListenMapper;
import com.knowledge.web.mapper.ReviewMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Component
public class InfoListenDao {
    @Autowired
    private InfoListenMapper infoListenMapper;

    public Page<InfoListen> getInfoListens(int pageNo, int pageSize, String keywords,Integer categoryId) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return infoListenMapper.getInfoListens(keywords,categoryId);
    }


    public void updateListennNewSign(BigInteger id) throws Exception {
        infoListenMapper.updateListennNewSign(id);
    }
    
    public void deleteInfoListen(BigInteger id) throws Exception {
        infoListenMapper.deleteInfoListen(id);
    }

    public void insertInfoListen(InfoListen infoListen){
        infoListenMapper.insertInfoListen(infoListen);
    }

    public InfoListen getInfoListenById(BigInteger id){
        return infoListenMapper.getInfoListenById(id);
    }

    public void updateInfoListen(InfoListen infoListen){
        infoListenMapper.updateInfoListen(infoListen);
    }

}
