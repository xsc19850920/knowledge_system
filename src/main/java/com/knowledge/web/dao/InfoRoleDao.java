package com.knowledge.web.dao;

import com.knowledge.web.domain.InfoRole;
import com.knowledge.web.mapper.InfoReadMapper;
import com.knowledge.web.mapper.InfoRoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by zhangfulong on 17/12/26.
 */
@Component
public class InfoRoleDao {
    @Autowired
    private InfoRoleMapper infoRoleMapper;

    public void insertInfoRole(InfoRole infoRole){
        infoRoleMapper.insertInfoRole(infoRole);
    }
    public List<InfoRole> getRolesByUserId(BigInteger id){
        return infoRoleMapper.getRolesByUserId(id);
    }
    public void updateInfoRole(BigInteger id,Integer status,String url){
        infoRoleMapper.updateInfoRole(id,status,url);
    }
}
