package com.woniu09.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author 康蓬勃
 * @create 2019/9/16
 * @since 1.0.0
 */
public class JDBCUtil {
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
        return  con;
    }
    public  void  release(ResultSet rs, Statement st,Connection con) throws  Exception{
        if(rs!=null){
            rs.close();
        }
        if(st!=null){
            st.close();
        }
        if(con!=null){
            con.close();

        }
    }
}