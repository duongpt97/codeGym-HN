package com.example.shopapp.service;

import com.example.shopapp.databases.DatabasesConnect;
import com.example.shopapp.enitty.Book;
import com.example.shopapp.enitty.User;
import com.example.shopapp.model.BookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookModel bookModel;

    public void BookService() throws ServletException, IOException {
        this.bookModel = new BookModel();
    }

    public void renderListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Book> books = this.bookModel.getBooks();
        req.setAttribute("books", books);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/book/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.bookModel.destroyBook(id);
    }
}
