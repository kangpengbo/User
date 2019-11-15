package com.woniu09.user.controller;

import com.woniu09.user.dao.UserDao;
import com.woniu09.user.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author 康蓬勃
 * @create 2019/9/16
 * @since 1.0.0
 */
@WebServlet("/loginsuccess")
public class LoginSussessServlet extends HttpServlet {
    UserDao userDao=new UserDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.println("登录成功");
            List<User> list=userDao.selectList();
            System.out.println(list);
            req.setCharacterEncoding("utf-8");
            req.setAttribute("users",list);
            resp.setCharacterEncoding("utf-8");
            req.getRequestDispatcher("/JSP/loginsuccess.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}