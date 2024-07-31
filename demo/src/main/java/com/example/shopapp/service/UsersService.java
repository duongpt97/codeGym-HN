package com.example.shopapp.service;

import com.example.shopapp.enitty.User;
import com.example.shopapp.model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersService {
    private UserModel userModel;

    public UsersService() {
        userModel = new UserModel();
    }

    public void renderPageUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userModel.getListUsers();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/user/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void renderCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/user/createUser.jsp");
        requestDispatcher.forward(req, resp);

    }

    public void deleteUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.userModel.deleteListUsers(id);
        resp.sendRedirect("/user");
    }

    public void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = String.valueOf(req.getParameter("name"));
        String email = String.valueOf(req.getParameter("email"));
        int role = Integer.parseInt(req.getParameter("role"));
        User user = new User(id, name, email, role);
        this.userModel.addUsers(user);
        resp.sendRedirect("/user");
    }
}
