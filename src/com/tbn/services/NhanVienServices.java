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
}
