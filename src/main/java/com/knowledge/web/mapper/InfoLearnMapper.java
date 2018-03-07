package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.InfoLearn;
import com.knowledge.web.domain.InfoListen;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
public interface InfoLearnMapper {
    Page<InfoLearn> getInfoLearns(@Param("keywords")String keywords);
    void deleteInfoLearn(@Param("id")BigInteger id);
    void insertInfoLearn(@Param("infoLearn") InfoLearn infoLearn);
    InfoLearn getInfoLearnById(@Param("id")BigInteger id);
    void updateInfoLearn(@Param("infoLearn") InfoLearn infoLearn);
}
