package com.knowledge.web.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.knowledge.web.domain.User;
import com.knowledge.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    public Page<User> getUsers(int pageNo,int pageSize,String keywords) throws Exception {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.getUsers(keywords);
    }

    public User userLogin(String account,String password) throws Exception {
        return userMapper.userLogin(account,password);
    }

    public void deleteUser(BigInteger id) throws Exception {
        userMapper.deleteUser(id);
    }

    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public User getUserById(BigInteger id){
        return userMapper.getUserById(id);
    }

    public User getUserByAccount(String account){
        return userMapper.getUserByAccount(account);
    }

    public void updateUser(User user){
        userMapper.updateUser(user);
    }
}


