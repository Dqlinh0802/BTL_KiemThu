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
public class Sach {
    private String maSach;
    private String tenSach;
    private int soLuong;
    private String moTaSach;
    private String namXuatBan;

    public Sach(String maSach, String tenSach, int soLuong, String namXuatBan, String moTaSach) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.namXuatBan = namXuatBan;
        this.moTaSach = moTaSach;
    }
    

    @Override
    public String toString() {
        return this.tenSach;
    }
    
    
    public Sach(String maSach) {
        this.maSach = maSach;
    }
    /**
     * @return the maSach
     */
    public String getMaSach() {
        return maSach;
    }

    /**
     * @param maSach the maSach to set
     */
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    /**
     * @return the tenSach
     */
    public String getTenSach() {
        return tenSach;
    }

    /**
     * @param tenSach the tenSach to set
     */
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the moTaSach
     */
    public String getMoTaSach() {
        return moTaSach;
    }

    /**
     * @param moTaSach the moTaSach to set
     */
    public void setMoTaSach(String moTaSach) {
        this.moTaSach = moTaSach;
    }

    /**
     * @return the namXuatBan
     */
    public String getNamXuatBan() {
        return namXuatBan;
    }

    /**
     * @param namXuatBan the namXuatBan to set
     */
    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }
    
}
