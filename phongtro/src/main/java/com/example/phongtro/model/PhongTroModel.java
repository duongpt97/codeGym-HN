package com.example.phongtro.model;


import com.example.phongtro.database.DatabaseConnection;
import com.example.phongtro.dto.PhongTroDto;
import com.example.phongtro.entity.PhongTro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhongTroModel {
    private Connection con;

    public PhongTroModel() {
        this.con = DatabaseConnection.getConnection();
    }
    public List<PhongTro> search(PhongTroDto searchRoomDto) throws SQLException {
        String sql = " SELECT  " +
                "    a.id, " +
                "    a.ma_phong, " +
                "    a.ten_nguoi_thue, " +
                "    a.so_dien_thoai, " +
                "    a.ngay_bat_dau, " +
                "    a.hinh_thuc_thanh_toan_id, " +
                "    a.ghi_chu, " +
                "    b.ten_hinh_thuc " +
                " FROM " +
                "    phongtro a " +
                " LEFT JOIN " +
                "    hinhthucthanhtoan b ON b.status = 1 AND b.id = a.hinh_thuc_thanh_toan_id " +
                " where a.status =1 ";
        if (searchRoomDto.getInput() != null) {
            sql += "   and ( a.ma_phong like ? or a.ten_nguoi_thue like ? or a.so_dien_thoai like ? ) ";
        }
        sql += " ORDER BY a.ma_phong ASC ";
        sql += " limit ? offset ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sql);
        int index = 1;
        if (searchRoomDto.getInput() != null) {
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
        }
        preparedStatement.setInt(index++, searchRoomDto.getSize());
        preparedStatement.setInt(index++, (searchRoomDto.getPage() - 1) * searchRoomDto.getSize());
        ResultSet rs = preparedStatement.executeQuery();
        List<PhongTro> roomList = new ArrayList<>();
        while (rs.next()) {
            PhongTro room = new PhongTro();
            room.setId(rs.getInt(1));
            room.setMaPhong(rs.getString(2));
            room.setTenNguoiThue(rs.getString(3));
            room.setSoDienThoai(rs.getString(4));
            room.setNgayBatDau(rs.getDate(5));
            room.setHinhThucThanhToanId(rs.getInt(6));
            room.setGhiChu(rs.getString(6));
            room.setTenHinhThuc(rs.getString(6));
            roomList.add(room);
        }
        return roomList;
    }

    public Integer count(PhongTroDto searchRoomDto) throws SQLException {
        String sql = "SELECT count(1) " +
                " FROM (   SELECT  " +
                "    a.id, " +
                "    a.ma_phong, " +
                "    a.ten_nguoi_thue, " +
                "    a.so_dien_thoai, " +
                "    a.ngay_bat_dau, " +
                "    a.hinh_thuc_thanh_toan_id, " +
                "    a.ghi_chu, " +
                "    b.ten_hinh_thuc " +
                " FROM " +
                "    phongtro a " +
                " LEFT JOIN " +
                "    hinhthucthanhtoan b ON b.status = 1 AND b.id = a.hinh_thuc_thanh_toan_id " +
                " where a.status =1 ";
        if (searchRoomDto.getInput() != null) {
            sql += "   and ( a.ma_phong like ? or a.ten_nguoi_thue like ? or a.so_dien_thoai like ? ) ";
        }
        sql += " ) c ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sql);
        int index = 1;
        if (searchRoomDto.getInput() != null) {
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
            preparedStatement.setString(index++, "%" + searchRoomDto.getInput() + "%");
        }
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public int create(String homeCode, String customerName, String phoneNumber, Date startDate, Long paymentMethodId, String note) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into phongtro (ma_phong,ten_nguoi_thue,so_dien_thoai,ngay_bat_dau,hinh_thuc_thanh_toan_id,ghi_chu,status) ");
        sb.append("values (?,?,?,?,?,?,1) ");
        PreparedStatement ps = this.con.prepareStatement(sb.toString());
        ps.setString(1, homeCode);
        ps.setString(2, customerName);
        ps.setString(3, phoneNumber);
        ps.setDate(4, new java.sql.Date(startDate.getTime()));
        ps.setLong(5, paymentMethodId);
        ps.setString(6, note);
        return ps.executeUpdate();
    }
}
