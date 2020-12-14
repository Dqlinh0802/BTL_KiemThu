/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.DocGia;
import com.tbn.pojo.Sach;
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
public class DocGiaServices {
    public static List<DocGia> getDocGia(String kw) throws SQLException {
        Connection conn = Utils.getConn();
        
        String sql = "SELECT * FROM docgia"; 
        
        PreparedStatement stm = conn.prepareStatement(sql);

        if (kw != null && !kw.trim().isEmpty()) {
            stm.setString(1, String.format("%%%s%%", kw));
        }

        ResultSet rs = stm.executeQuery();
        
        
        List<DocGia> kq = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("maDocGia");
            String tenDocGia = rs.getString("tenDocGia");
            String doiTuong = rs.getString("doiTuong");
            String boPhan = rs.getString("boPhan");

            
            DocGia c = new DocGia(id, tenDocGia, doiTuong, boPhan);
            kq.add(c);
        }
        
        return kq;
        
    }
    
    //thêm độc giả
    public static boolean addDocGia(DocGia s) {
        Connection conn = Utils.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO DocGia(maDocGia, tenDocGia, gioiTinh, ngaySinh, doiTuong, boPhan, ngayDangKy, email, sdt, diaChi)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            
            stm.setString(1, s.getMaDocGia());
            stm.setString(2, s.getTenDocGia());
            stm.setString(3, s.getGioiTinh());
            stm.setString(4, s.getNgaySinh());
            stm.setString(5, s.getDoiTuong());
            stm.setString(6, s.getBoPhan());
            stm.setString(7, s.getNgayDangKy());
            stm.setString(8, s.getEmail());
            stm.setString(9, s.getSdt());
            stm.setString(10, s.getDiaChi());
            
            stm.executeUpdate();
            conn.commit();          

            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DocGiaServices.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return false;
    }
    
    //xóa sách
    public static boolean deleteDocGia(String maDocGia) throws SQLException{
        Connection conn = Utils.getConn();
        String sql = "DELETE FROM docgia WHERE maDocGia=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, maDocGia);
        
        int kq = stm.executeUpdate();
        return kq > 0;
    }
    
    public static DocGia getById(String maSach) throws SQLException {
        Connection conn = Utils.getConn();
        String sql = "SElECT * FROM sach WHERE maSach=?";
        
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, maSach);
        
        ResultSet rs = stm.executeQuery();
        while(rs.next())
            return new DocGia(maSach, rs.getString("tenDocGia"), rs.getString("doiTuong"), rs.getString("boPhan"));
        return null;
    }
    
}
