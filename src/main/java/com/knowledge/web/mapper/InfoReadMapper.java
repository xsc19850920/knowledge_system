package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.InfoRead;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
public interface InfoReadMapper {
    Page<InfoRead> getInfoReads(@Param("keywords")String keywords);
    void deleteInfoRead(@Param("id")BigInteger id);
    void updateReadNewSign(@Param("id")BigInteger id);
    void insertInfoRead(@Param("infoRead") InfoRead infoRead);
    InfoRead getInfoReadById(@Param("id")BigInteger id);
    void updateInfoRead(@Param("infoRead") InfoRead infoRead);
}
