/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.pojo;

/**
 *
 * @author Acer
 */
public class TheLoaiSach {
    private int id;
    private String TenLoaiSach;

    public TheLoaiSach(int id, String TenLoaiSach) {
        this.id = id;
        this.TenLoaiSach = TenLoaiSach;
    }

    public TheLoaiSach(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.TenLoaiSach;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the TenLoaiSach
     */
    public String getTenLoaiSach() {
        return TenLoaiSach;
    }

    /**
     * @param TenLoaiSach the TenLoaiSach to set
     */
    public void setTenLoaiSach(String TenLoaiSach) {
        this.TenLoaiSach = TenLoaiSach;
    }
    
}
