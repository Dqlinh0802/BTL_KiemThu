/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tbn.pojo;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class phieuMuon {
    private int maPhieuMuon;
    private Date ngayMuon;
    private Date ngayTra;
    private int soLuong;
    private DocGia docGia;
    private CTPM ctpm;

    public phieuMuon(int maPhieuMuon, Date ngayMuon, Date ngayTra, int soLuong, DocGia docGia, CTPM ctpm) {
        this.maPhieuMuon = maPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.soLuong = soLuong;
        this.docGia = docGia;
        this.ctpm = ctpm;
    }

    public phieuMuon(int maPhieuMuon, int soLuong, DocGia docGia, CTPM ctpm) {
        this.maPhieuMuon = maPhieuMuon;
        this.soLuong = soLuong;
        this.docGia = docGia;
        this.ctpm = ctpm;
    }

    
    
    
    /**
     * @return the maPhieuMuon
     */
    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    /**
     * @param maPhieuMuon the maPhieuMuon to set
     */
    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    /**
     * @return the ngayMuon
     */
    public Date getNgayMuon() {
        return ngayMuon;
    }

    /**
     * @param ngayMuon the ngayMuon to set
     */
    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    /**
     * @return the ngayTra
     */
    public Date getNgayTra() {
        return ngayTra;
    }

    /**
     * @param ngayTra the ngayTra to set
     */
    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
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
     * @return the docGia
     */
    public DocGia getDocGia() {
        return docGia;
    }

    /**
     * @param docGia the docGia to set
     */
    public void setDocGia(DocGia docGia) {
        this.docGia = docGia;
    }

    /**
     * @return the ctpm
     */
    public CTPM getCtpm() {
        return ctpm;
    }

    /**
     * @param ctpm the ctpm to set
     */
    public void setCtpm(CTPM ctpm) {
        this.ctpm = ctpm;
    }
}
