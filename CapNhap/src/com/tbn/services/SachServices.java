/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.services;

import com.tbn.pojo.Sach;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class SachServices {
    public static List<Sach> getSach() throws SQLException{
            Connection  conn = Utils.getConn();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM sach");
            
            List<Sach> kq = new ArrayList<>();
            
            while(rs.next()){
                int maSach = rs.getInt("maSach");
                String tenSach = rs.getNString("tenSach");
                int soLuong = rs.getInt("soLuong");
                String namXuatBan = rs.getString("namXuatBan");
                String moTa = rs.getNString("moTa");
                
                Sach c = new Sach(maSach, tenSach, soLuong, namXuatBan, moTa);
                kq.add(c);
            }
            return kq;
    }
}
