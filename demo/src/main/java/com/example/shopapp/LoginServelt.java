package com.example.shopapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServelt", urlPatterns = "/login-servlet")
public class LoginServelt extends HttpServlet {
    private String message;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.doGet(req,res);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, res);
        System.out.println("Login win method get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.doPost(req,res);
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.println("userName: " + userName);
        System.out.println("password: " + password);
        if (userName.equals("admin") && password.equals("1234")) {
            System.out.println("Xin chao Admin");
        } else {
            res.sendRedirect("hello-servlet");
        }
        System.out.println("Login win method Post");
    }


    public void destroy() {
        super.destroy();
    }
}