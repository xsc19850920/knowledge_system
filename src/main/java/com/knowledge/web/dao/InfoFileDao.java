package com.knowledge.web.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.InfoFile;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.mapper.InfoFileMapper;
import com.knowledge.web.mapper.InfoListenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
@Component
public class InfoFileDao {
    @Autowired
    private InfoFileMapper infoFileMapper;

    public void insertInfoFile(InfoFile infoFile){
        infoFileMapper.insertInfoFile(infoFile);
    }

    public InfoFile getInfoFileById(BigInteger id){
        return infoFileMapper.getInfoFileById(id);
    }

    public void updateInfoFile(InfoFile infoFile){
        infoFileMapper.updateInfoFile(infoFile);
    }
}
