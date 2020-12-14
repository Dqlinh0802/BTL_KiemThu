/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class NhanVienServices {
    public static  List<NhanVien> getNhanVien(String kw) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "SELECT * FROM nhanvien"; 
        
        PreparedStatement stm = conn.prepareStatement(sql);

        if (kw != null && !kw.isEmpty()) {
            stm.setString(1, String.format("%%%s%%", kw));
        }

        ResultSet rs = stm.executeQuery();
        
        
        List<NhanVien> kq = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("maNV");
            String tenNV = rs.getString("tenNV");
            String gioiTinh = rs.getString("gioiTinh");
            String sdt = rs.getString("sdt");

            NhanVien c = new NhanVien(id, tenNV, gioiTinh, sdt);
            kq.add(c);
        }
        return kq;
    }
    
    public static boolean addNV(NhanVien s) {
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO NhanVien(maNV, tenNV, gioiTinh, ngaySinh, email, diaChi, sdt, tenDangNhap, matKhau)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, s.getMaNV());
            stm.setString(2, s.getTenNV());
            stm.setString(3, s.getGioiTinh());
            stm.setString(4, s.getNgaySinh());
            stm.setString(5, s.getEmail());
            stm.setString(6, s.getDiaChi());
            stm.setString(7, s.getSdt());
            stm.setString(8, s.getTenDangNhap());
            stm.setString(9, s.getMatKhau());
            
            stm.executeUpdate();
            conn.commit();          

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return false;
    }
    
}
