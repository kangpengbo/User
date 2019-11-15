package com.woniu09.user.controller;

import com.woniu09.user.dao.UserDao;
import com.woniu09.user.entity.User;

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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    UserDao userDao=new UserDao();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        String username=user.getUsername();
        try {
            userDao.deleteUser(username);
            req.getRequestDispatcher("/JSP/delete.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}