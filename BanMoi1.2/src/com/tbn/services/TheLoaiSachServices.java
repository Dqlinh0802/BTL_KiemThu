/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.TheLoaiSach;
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
public class TheLoaiSachServices {
    public static  List<TheLoaiSach> getTheLoaiSach(String kw) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "SELECT * FROM loaisach"; 

        if (kw != null && !kw.trim().isEmpty())
            sql += " WHERE tenLoaiSach like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);

        if (kw != null && !kw.isEmpty()) {
            stm.setString(1, String.format("%%%s%%", kw));
        }

        ResultSet rs = stm.executeQuery();
        
        
        List<TheLoaiSach> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("maLoaiSach");
            String name = rs.getString("tenLoaiSach");
            
            TheLoaiSach c = new TheLoaiSach(id, name);
            kq.add(c);
        }
        return kq;
    }
    
    public static  String getTenTheLoai(int kw) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "SELECT tenLoaiSach FROM loaisach";

        sql += " WHERE id =?";
        
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setString(1, String.format("%%%s%%", kw));

        
        return sql;
    }
    
    public static TheLoaiSach getTheLoaiSachByID(int id) throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "SElECT * FROM loaisach WHERE id=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        
        ResultSet rs = stm.executeQuery();
        while(rs.next())
            return new TheLoaiSach(id, sql);
        return null;
    }
    
    //Thêm thể loại
    public static boolean addTheLoaiSach(TheLoaiSach t) {
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO loaisach(maLoaiSach, tenLoaiSach)" + "VALUES(?, ?)";
            
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, t.getId());
            stm.setString(2, t.getTenLoaiSach());
            
            stm.executeUpdate();
            conn.commit();          

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SachServices.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return false;
    }
}
