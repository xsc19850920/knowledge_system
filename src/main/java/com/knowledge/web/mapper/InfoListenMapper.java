package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.InfoListen;
import com.knowledge.web.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
public interface InfoListenMapper {
    Page<InfoListen> getInfoListens(@Param("keywords")String keywords,@Param("categoryId")Integer categoryId);
    void deleteInfoListen(@Param("id")BigInteger id);
    void updateListennNewSign(@Param("id")BigInteger id);
    void insertInfoListen(@Param("infoListen") InfoListen infoListen);
    InfoListen getInfoListenById(@Param("id")BigInteger id);
    void updateInfoListen(@Param("infoListen") InfoListen infoListen);
}
