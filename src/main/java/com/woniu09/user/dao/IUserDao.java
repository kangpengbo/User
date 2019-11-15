package com.woniu09.user.dao;

import com.woniu09.user.entity.User;

import java.util.List;

public interface IUserDao {
    User selectUserByName(String name) throws  Exception;
    List<User> selectList() throws  Exception;
    void InsertUser(String username, String password, String birthday,String sex) throws  Exception;
    void deleteUser(String username) throws  Exception;
    void updateUser(String username,String password) throws  Exception;
}
