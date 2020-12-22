package com.news.util.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginOutServlet",urlPatterns = {"/LoginOutServlet"})
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //统一处理请求
        //要把session中保存的数据全部销毁掉
        HttpSession session=request.getSession();
        session.invalidate();
        //发送请求，给用户一个提示信息
        request.getRequestDispatcher("/pages/LoginOutSucess.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }
}
