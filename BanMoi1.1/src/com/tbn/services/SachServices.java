/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.Sach;
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
public class SachServices {
    public static List<Sach> getSach(String kw) throws SQLException{
        Connection  conn = Utils.getConn();
            
        String sql = "SELECT * FROM sach";

        if (kw != null && !kw.trim().isEmpty())
            sql += " WHERE tenSach like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);

        if (kw != null && !kw.isEmpty()) {
            stm.setString(1, String.format("%%%s%%", kw));
        }

        ResultSet rs = stm.executeQuery();

        List<Sach> s = new ArrayList<>();
        while (rs.next()) {
            
            String maSach = rs.getString("maSach");
            String tenSach = rs.getString("tenSach");
            int soLuong = rs.getInt("soLuong");
            String moTaSach = rs.getString("moTaSach");
            String namXuatBan = rs.getString("namXuatBan");
            
            Sach c = new Sach(maSach, tenSach, soLuong, namXuatBan, moTaSach);

            s.add(c);
        }
        
        return s;
        
    }
}
