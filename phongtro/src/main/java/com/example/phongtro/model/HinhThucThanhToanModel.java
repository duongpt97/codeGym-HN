package com.example.phongtro.model;


import com.example.phongtro.database.DatabaseConnection;
import com.example.phongtro.dto.HinhThucThanhToanDto;
import com.example.phongtro.dto.PhongTroDto;
import com.example.phongtro.entity.HinhThucThanhToan;
import com.example.phongtro.entity.PhongTro;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhThucThanhToanModel {
    private Connection con;

    public HinhThucThanhToanModel() {
        this.con = DatabaseConnection.getConnection();
    }

    public List<HinhThucThanhToan> getAllHinhThuc() throws SQLException {
        String sql = "SELECT id,ten_hinh_thuc,status " + "   FROM hinhthucthanhtoan where status = 1";
        PreparedStatement preparedStatement = this.con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        List<HinhThucThanhToan> lst = new ArrayList<>();
        while (rs.next()) {
            HinhThucThanhToan model = new HinhThucThanhToan();
            model.setId(rs.getInt(1));
            model.setTenHinhThuc(rs.getString(2));
            model.setStatus(rs.getInt(3));

            lst.add(model);
        }
        return lst;
    }

}
