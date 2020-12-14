/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.Sach;
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
public class SachServices {
    public static List<Sach> getSach(String kw) throws SQLException{
        Connection  conn = Utils.getConn();
            
        String sql = "SELECT * FROM sach";

        if (kw != null && !kw.trim().isEmpty())
            sql += " WHERE tenSach like ?";
        
        PreparedStatement stm = conn.prepareStatement(sql);

        if (kw != null && !kw.trim().isEmpty()) {
            stm.setString(1, String.format("%%%s%%", kw));
        }

        ResultSet rs = stm.executeQuery();

        List<Sach> s = new ArrayList<>();
        while (rs.next()) {
            
            String maSach = rs.getString("maSach");
            String tenSach = rs.getString("tenSach");
            int soLuong = rs.getInt("soLuong");
            String namXuatBan = rs.getString("namXuatBan");
            String moTaSach = rs.getString("moTaSach");
            int Id = rs.getInt("maLoaiSach");
            TheLoaiSach t = new TheLoaiSach(Id);
            
            Sach c = new Sach(maSach, tenSach, soLuong, namXuatBan, moTaSach, t);

            s.add(c);
        }
        
        return s;
        
    }
    
    public static List<Sach> getNXB(String kw) throws SQLException{
        Connection  conn = Utils.getConn();
            
        String sql = "SELECT * FROM sach";

        if (kw != null && !kw.trim().isEmpty())
            sql += " WHERE namXuatBan like ?";
        
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
            String namXuatBan = rs.getString("namXuatBan");
            String moTaSach = rs.getString("moTaSach");
            int Id = rs.getInt("maLoaiSach");
            TheLoaiSach t = new TheLoaiSach(Id);
            
            Sach c = new Sach(maSach, tenSach, soLuong, namXuatBan, moTaSach, t);

            s.add(c);
        }
        
        return s;
        
    }
    
    public static List<Sach> getTL(String kw) throws SQLException{
        Connection  conn = Utils.getConn();
            
        String sql = "SELECT * FROM sach";

        if (kw != null && !kw.trim().isEmpty())
            sql += " WHERE moTaSach like ?";
        
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
            String namXuatBan = rs.getString("namXuatBan");
            String moTaSach = rs.getString("moTaSach");
            int Id = rs.getInt("maLoaiSach");
            TheLoaiSach t = new TheLoaiSach(Id);
            
            Sach c = new Sach(maSach, tenSach, soLuong, namXuatBan, moTaSach, t);

            s.add(c);
        }
        
        return s;
        
    }
    
    
    //thêm sách
    public static boolean addSach(Sach s) {
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO sach(maSach, tenSach, soLuong, namXuatBan, moTaSach, maLoaiSach)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, s.getMaSach());
            stm.setString(2, s.getTenSach());
            stm.setInt(3, s.getSoLuong());
            stm.setString(4, s.getNamXuatBan());
            stm.setString(5, s.getMoTaSach());
            stm.setInt(6, s.getTheLoaiSach().getId());
            
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
    
    //xóa sách
    public static boolean deleteSach(String maSach) throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "DELETE FROM Sach WHERE maSach=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, maSach);
        
        int kq = stm.executeUpdate();
        return kq > 0;
    }
    
    public static void muon(String maSach, int soLuong) throws SQLException {
        Connection conn = Utils.getConn();
        //String sql = "UPDATE sach SET 'soLuong' = 'soLuong - 1' WHERE ('id' ='?')";
        String sql = "UPDATE sach SET soLuong =? WHERE maSach = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(2,maSach);
        stm.setInt(1, soLuong-1);
        stm.executeUpdate();
    }
    
     public static Sach getSachById(String maSach) throws SQLException {
        Connection conn = Utils.getConn();
        String sql = "SElECT * FROM sach WHERE maSach=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, maSach);
        
        ResultSet rs = stm.executeQuery();
        while(rs.next())
            return new Sach(rs.getString("maSach"), rs.getString("tenSach"), 
                    rs.getInt("soLuong"), rs.getString("namXuatBan"), rs.getString("moTaSach"));
        return null;
    }
    
}