package com.example.phongtro.controler;

import com.example.phongtro.service.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/room/*")
public class PhongTroControler extends HttpServlet {

    private PhongTroService phongTroService;

    @Override
    public void init() {
        this.phongTroService = new PhongTroService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getPathInfo() == null) {
            req.getRequestDispatcher("/views/room-list.jsp").forward(req, resp);
            return;
        }
        String url = req.getPathInfo();
        try {
            switch (url) {
                case "/create":
                phongTroService.renderCreateRoom(req, resp);
                    break;
                case "/delete":
//                phongTroService.deleteBook(req, resp);
                    break;
                case "/search":
                    phongTroService.renderRoomManager(req, resp);
                    break;
                default:
                    phongTroService.renderRoomManager(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()) {
            case "/create":
                phongTroService.createRoom(req, resp);
                break;
        }
    }
}