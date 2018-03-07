package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.InfoFile;
import com.knowledge.web.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/25.
 */
public interface InfoFileMapper {
    void insertInfoFile(@Param("infoFile") InfoFile InfoFile);
    InfoFile getInfoFileById(@Param("id")BigInteger id);
    void updateInfoFile(@Param("infoFile") InfoFile InfoFile);
}
