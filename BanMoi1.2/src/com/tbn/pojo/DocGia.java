/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.pojo;

import java.util.Date;

/**
 *
 * @author Acer
 */
public class DocGia {
    private String maDocGia;
    private String tenDocGia;
    private String gioiTinh;
    private String ngaySinh;
    private String doiTuong;
    private String boPhan;
    private String ngayDangKy;
    private String email;
    private String sdt;
    private String diaChi;

    public DocGia(String maDocGia, String tenDocGia, String gioiTinh
            , String ngaySinh, String doiTuong, String boPhan, String ngayDangKy
            , String email, String sdt, String diaChi) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.doiTuong = doiTuong;
        this.boPhan = boPhan;
        this.ngayDangKy = ngayDangKy;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public DocGia(String maDocGia, String tenDocGia, String doiTuong, String boPhan) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.doiTuong = doiTuong;
        this.boPhan = boPhan;
    }

    
    
    /**
     * @return the maDocGia
     */
    public String getMaDocGia() {
        return maDocGia;
    }

    /**
     * @param maDocGia the maDocGia to set
     */
    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    /**
     * @return the tenDocGia
     */
    public String getTenDocGia() {
        return tenDocGia;
    }

    /**
     * @param tenDocGia the tenDocGia to set
     */
    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }


    /**
     * @return the doiTuong
     */
    public String getDoiTuong() {
        return doiTuong;
    }

    /**
     * @param doiTuong the doiTuong to set
     */
    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }



    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the ngayDangKy
     */
    public String getNgayDangKy() {
        return ngayDangKy;
    }

    /**
     * @param ngayDangKy the ngayDangKy to set
     */
    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
}
