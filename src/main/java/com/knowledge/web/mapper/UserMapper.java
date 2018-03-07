package com.knowledge.web.mapper;

import com.github.pagehelper.Page;
import com.knowledge.web.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;

@Mapper
public interface UserMapper {
    Page<User> getUsers(@Param("keywords")String keywords);
    User userLogin(@Param("account")String account,@Param("password")String password);
    void deleteUser(@Param("id")BigInteger id);
    void insertUser(@Param("user") User user);
    User getUserById(@Param("id")BigInteger id);
    User getUserByAccount(@Param("account")String account);
    void updateUser(@Param("user") User user);
}