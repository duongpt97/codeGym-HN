package com.example.shopapp.controler;

import com.example.shopapp.service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserControler", urlPatterns = "/users/*")
public class UserControler extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        this.usersService = new UsersService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null) {
            this.usersService.renderPageUserList(req, resp);
            return;
        }
        switch (url) {
            case "/delete":
                this.usersService.deleteUsers(req, resp);
            case "/create":
                this.usersService.renderCreatePage(req, resp);
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.usersService.createUser(req, resp);
    }
}
