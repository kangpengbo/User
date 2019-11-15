package com.woniu09.user.dao;

import com.woniu09.user.entity.User;
import com.woniu09.user.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author 康蓬勃
 * @create 2019/9/16
 * @since 1.0.0
 */
public class UserDao implements IUserDao {
    JDBCUtil jdbcUtil=new JDBCUtil();
    @Override
    public User selectUserByName(String name) throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        connection=jdbcUtil.getConnection();
        String sql="select  * from user where username=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,name);
        resultSet=preparedStatement.executeQuery();
        User user=new User();
        if (resultSet.next()){
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setUserid(resultSet.getInt("userid"));
        }
        jdbcUtil.release(resultSet,preparedStatement,connection);
        return user;
    }

    @Override
    public List<User> selectList() throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        connection=jdbcUtil.getConnection();
        String sql="select  * from user";
        preparedStatement=connection.prepareStatement(sql);
        resultSet=preparedStatement.executeQuery();
       List<User> list=new ArrayList<>();
        while (resultSet.next()){
            User user=new User();
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getDate("birthday"));
            user.setUserid(resultSet.getInt("userid"));
            System.out.println("user之前"+user);
            list.add(user);
        }
        jdbcUtil.release(resultSet,preparedStatement,connection);
        return list;
    }

    @Override
    public void InsertUser(String username, String password, String birthday, String sex) throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        connection=jdbcUtil.getConnection();
        String sql="insert into user (username,password,birthday,sex) values(?,?,?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,username);
        preparedStatement.setObject(2,password);
        preparedStatement.setObject(3,birthday);
        preparedStatement.setObject(4,sex);
        preparedStatement.execute();
        jdbcUtil.release(resultSet,preparedStatement,connection);
    }

    @Override
    public void deleteUser(String username) throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        connection=jdbcUtil.getConnection();
        String sql="delete from user where username=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,username);
        preparedStatement.execute();
        jdbcUtil.release(resultSet,preparedStatement,connection);
    }

    @Override
    public void updateUser(String username,String password) throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        connection=jdbcUtil.getConnection();
        String sql="update user set password=? where username=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,password);
        preparedStatement.setObject(2,username);
        preparedStatement.execute();
        jdbcUtil.release(resultSet,preparedStatement,connection);
    }
}