package com.example.shopapp.controler;

import com.example.shopapp.enitty.Book;
import com.example.shopapp.model.BookModel;
import com.example.shopapp.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookControler", urlPatterns = {"/books/*"})
public class BookControler extends HttpServlet {
    private BookModel bookModel;
    private BookService bookService;

    public void init(ServletConfig config) throws ServletException {
        this.bookModel = new BookModel();
        this.bookService = bookService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null || url.equals("/")) {
            this.renderListBook(req, resp);
        }
    }

    private void renderListBook(HttpServletRequest req, HttpServletResponse resp) {

    }
}
