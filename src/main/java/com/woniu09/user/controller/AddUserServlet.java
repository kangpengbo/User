package com.woniu09.user.controller;

import com.woniu09.user.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author 康蓬勃
 * @create 2019/9/16
 * @since 1.0.0
 */
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    UserDao userDao=new UserDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String birthday=req.getParameter("birthday");
        String sex=req.getParameter("sex");
        System.out.println(sex+"sex");
        try {
            userDao.InsertUser(username,password,birthday,sex);
            req.getRequestDispatcher("/JSP/addsuccess.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}