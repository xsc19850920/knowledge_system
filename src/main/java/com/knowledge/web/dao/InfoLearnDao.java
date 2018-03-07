package com.knowledge.web.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.InfoLearn;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.mapper.InfoLearnMapper;
import com.knowledge.web.mapper.InfoListenMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Component
public class InfoLearnDao {
    @Autowired
    private InfoLearnMapper infoLearnMapper;

    public Page<InfoLearn> getInfoLearns(int pageNo, int pageSize, String keywords) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return infoLearnMapper.getInfoLearns(keywords);
    }

    
    public void deleteInfoLearn(BigInteger id) throws Exception {
        infoLearnMapper.deleteInfoLearn(id);
    }

    public void insertInfoLearn(InfoLearn infoLearn){
        infoLearnMapper.insertInfoLearn(infoLearn);
    }

    public InfoLearn getInfoLearnById(BigInteger id){
        return infoLearnMapper.getInfoLearnById(id);
    }

    public void updateInfoLearn(InfoLearn infoLearn){
        infoLearnMapper.updateInfoLearn(infoLearn);
    }
}
