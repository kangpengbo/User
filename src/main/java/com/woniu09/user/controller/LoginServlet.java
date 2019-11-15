package com.woniu09.user.controller;

import com.woniu09.user.dao.UserDao;
import com.woniu09.user.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author 康蓬勃
 * @create 2019/9/16
 * @since 1.0.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao=new UserDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
       String username=req.getParameter("username");
       String password=req.getParameter("password");

        User user= null;
        try {
            user = userDao.selectUserByName(username);
            System.out.println(username+"|"+user);
            if(user!=null||password!=null){
                if(password.equals(user.getPassword())){
                    req.getSession().setAttribute("user",user);
                    resp.sendRedirect("/UserWeb/loginsuccess");
                }else {
                    req.setAttribute("info","密码错误！！！");
                    req.getRequestDispatcher("/JSP/login.jsp").forward(req,resp);
                }
            }else {
                req.setAttribute("info","用户名不存在！！！");
                req.getRequestDispatcher("/JSP/login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}