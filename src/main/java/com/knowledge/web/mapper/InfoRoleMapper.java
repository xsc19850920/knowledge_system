package com.knowledge.web.mapper;

import com.knowledge.web.domain.InfoRole;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by zhangfulong on 17/12/26.
 */
public interface InfoRoleMapper {
    void insertInfoRole(@Param("infoRole") InfoRole infoRole);
    List<InfoRole> getRolesByUserId(@Param("id")BigInteger id);
    void updateInfoRole(@Param("id")BigInteger id,@Param("status")Integer status,@Param("url")String url);
}
