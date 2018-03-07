package com.knowledge.web.controller;

import com.knowledge.web.dao.InfoRoleDao;
import com.knowledge.web.dao.UserDao;
import com.knowledge.web.domain.InfoRole;
import com.knowledge.web.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by zhangfulong on 17/12/26.
 */

@Controller
@RequestMapping("/")
public class InfoRoleController {

    @Autowired
    private InfoRoleDao infoRoleDao;

    @RequestMapping(value = "/insertInfoRole",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertInfoRole(BigInteger userId,String url,Integer status) throws Exception {
        InfoRole infoRole = new InfoRole();
        infoRole.setInfoRoleId(BigInteger.valueOf(System.currentTimeMillis()));
        infoRole.setUserId(userId);
        infoRole.setStatus(status);
        infoRole.setUrl(url);
        infoRoleDao.insertInfoRole(infoRole);
        return true;
    }

    @RequestMapping(value = "/getRolesByUserId",method = RequestMethod.POST)
    @ResponseBody
    public List<InfoRole> getRolesByUserId(@RequestParam(value="id") BigInteger id) {
        return infoRoleDao.getRolesByUserId(id);
    }

    @RequestMapping(value = "/updateInfoRole",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateInfoRole(@RequestParam(value="id") BigInteger id,@RequestParam(value="status") Integer status,@RequestParam(value="url") String url) throws Exception {
        infoRoleDao.updateInfoRole(id,status,url);
        return true;
    }

}
