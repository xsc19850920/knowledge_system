package com.knowledge.web.controller;

import com.github.pagehelper.Page;
import com.knowledge.web.dao.InfoRoleDao;
import com.knowledge.web.dao.UserDao;
import com.knowledge.web.domain.InfoRole;
import com.knowledge.web.domain.User;
import com.knowledge.web.util.PageInfo;

import weibo4j.http.BASE64Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private InfoRoleDao infoRoleDao;

    @RequestMapping(value = "/getusers",method = RequestMethod.POST)
    @ResponseBody
    public PageInfo<User> getUsers(String keywords, int pageNo, int pageSize) throws Exception {
        Page<User> users = userDao.getUsers(pageNo, pageSize,keywords);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    @ResponseBody
    public Boolean deleteUser(@RequestParam(value="id") BigInteger id) throws Exception {
        userDao.deleteUser(id);
        return true;
    }

    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertUser(String account,String password) throws Exception {
        User user = new User();
        BigInteger userId = BigInteger.valueOf(System.currentTimeMillis());
        user.setId(userId);
        user.setAccount(account);
        password = this.getMD5(password);
        user.setPassword(password);
        userDao.insertUser(user);
        String[] urls = {"user","review","listen","learn","read"};
        /*for(String url:urls){
        	BigInteger roleId = BigInteger.valueOf(System.currentTimeMillis());
        	
            InfoRole infoRole = new InfoRole();
            infoRole.setUrl(url);
            infoRole.setStatus(1);
            infoRole.setUserId(userId);
            
            infoRole.setInfoRoleId(roleId);
            infoRoleDao.insertInfoRole(infoRole);
        }*/
        for(int i=0;i<urls.length;i++) {
        	String url = urls[i];
            BigInteger roleId = BigInteger.valueOf(System.currentTimeMillis() + i);
            InfoRole infoRole = new InfoRole();
            infoRole.setUrl(url);
            infoRole.setStatus(1);
            infoRole.setUserId(userId);
            
            infoRole.setInfoRoleId(roleId);
            infoRoleDao.insertInfoRole(infoRole);
        }
        return true;
    }

    @RequestMapping(value = "/getuserbyid",method = RequestMethod.POST)
    @ResponseBody
    public User getUserById(@RequestParam(value="id") BigInteger id) {
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "/getuserbyaccout",method = RequestMethod.POST)
    @ResponseBody
    public Boolean getUserByAccount(@RequestParam(value="account") String account) {
        User u = userDao.getUserByAccount(account);
        if(u == null){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateUser(@RequestBody User user) throws Exception {
    	
    	String password = user.getPassword();
    	password = this.getMD5(password);
    	user.setPassword(password);
        userDao.updateUser(user);
        return true;
    }
    
    private  String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String md5=new BigInteger(1, md.digest()).toString(16);
            //BigInteger会把0省略掉，需补全至32位
            return md5;
            
        } catch (Exception e) {
            throw new RuntimeException("MD5加密错误:"+e.getMessage(),e);
        }
    }
}

