package com.knowledge.web.dao;/**
 * @author along
 * @create 2017-12-25 下午11:08
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.InfoRead;
import com.knowledge.web.mapper.InfoListenMapper;
import com.knowledge.web.mapper.InfoReadMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Component
public class InfoReadDao {
    @Autowired
    private InfoReadMapper infoReadMapper;

    public Page<InfoRead> getInfoReads(int pageNo, int pageSize, String keywords) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return infoReadMapper.getInfoReads(keywords);
    }

    public void deleteInfoRead(BigInteger id) throws Exception {
        infoReadMapper.deleteInfoRead(id);
    }

    public void updateReadNewSign(BigInteger id) throws Exception {
        infoReadMapper.updateReadNewSign(id);
    }
    
    public void insertInfoRead(InfoRead infoRead){
        infoReadMapper.insertInfoRead(infoRead);
    }

    public InfoRead getInfoReadById(BigInteger id){
        return infoReadMapper.getInfoReadById(id);
    }

    public void updateInfoRead(InfoRead infoRead){
        infoReadMapper.updateInfoRead(infoRead);
    }
}
