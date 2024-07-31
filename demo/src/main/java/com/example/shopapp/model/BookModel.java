package com.example.shopapp.model;

import com.example.shopapp.databases.DatabasesConnect;
import com.example.shopapp.enitty.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private Connection conn;

    public BookModel() {
        this.conn = DatabasesConnect.getConnection();
    }

    public List<Book> getBooks() throws SQLException {
        List<Book> lst = new ArrayList<>();
        String sql = "SELECT * FROM books";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString("name");
            String description = rs.getString("description");
            int price = rs.getInt("price");
            int categoryId = rs.getInt("category_id");
            Book book = new Book(id, name, description, price, categoryId);
            book.setId(id);
            book.setName(name);
            book.setDescription(description);
            book.setCategoryId(categoryId);
            lst.add(book);
        }
        return lst;
    }

    public void destroyBook(int id) throws SQLException {
        String sql = "DELETE FROM book WHERE id =?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
