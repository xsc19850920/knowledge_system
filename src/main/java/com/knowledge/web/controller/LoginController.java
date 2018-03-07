package com.knowledge.web.controller;

import com.knowledge.web.dao.UserDao;
import com.knowledge.web.domain.User;

import weibo4j.http.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class LoginController {

	
	

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "login")
    public String toHome() {
        return "login";
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    @ResponseBody
    public User checkUser( String account,String password) {
        User user = null;
        try {
        	password = this.getMD5(password);
            user = userDao.userLogin(account,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public String getMD5(String str) {
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
