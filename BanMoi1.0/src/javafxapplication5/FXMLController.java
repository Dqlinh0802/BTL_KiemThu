/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLController implements Initializable {

    @FXML private ImageView danhMuc, nguoiDung, muonTra, caiDat;
    @FXML private AnchorPane a1, a2, a3, a4;
    
    @FXML private void handleButtonAction(MouseEvent event){
        if(event.getTarget() == danhMuc)
        {
            a1.setVisible(true);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(false);
        }
        else if(event.getTarget() == nguoiDung)
        {
            a1.setVisible(false);
            a2.setVisible(true);
            a3.setVisible(false);
            a4.setVisible(false);
        }
        else if(event.getTarget() == muonTra)
        {
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(true);
            a4.setVisible(false);
        }
        else if(event.getTarget() == caiDat)
        {
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(true);
        }
    }
    @FXML private ImageView theLoaiSach, ngonNguSach, tacGia, nhaXuatBan, keSach, nhanVien, QLDocGia;
    @FXML private ImageView muonSach, traSach, chucNang1, chucNang2;
    @FXML private ImageView nguoiDungNho;
    @FXML private AnchorPane chuyenTrangDanhMuc, chuyenTrangNguoiDung, chuyenTrangMuonTra, chuyenTrangCaiDat;
    @FXML private AnchorPane trangTheLoaiSach, trangQuanLyDocGia;
    @FXML private void xuLyDanhMuc(MouseEvent event){
        if(event.getTarget() == theLoaiSach || event.getTarget() == ngonNguSach 
           || event.getTarget() == tacGia || event.getTarget() == nhaXuatBan || event.getTarget() == keSach)
        {
            chuyenTrangDanhMuc.setVisible(true);
            a1.setVisible(false);
            trangTheLoaiSach.setVisible(true);
            
        }
    }
    
    @FXML private void xuLyNguoiDung(MouseEvent event){
        if(event.getTarget() == nhanVien || event.getTarget() == QLDocGia || event.getTarget() == nguoiDungNho)
        {
            chuyenTrangNguoiDung.setVisible(true);
            a2.setVisible(false);
            trangQuanLyDocGia.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
    }
    
    @FXML private void xuLyMuonTra(MouseEvent event){
        if(event.getTarget() == muonSach || event.getTarget() == traSach )
        {
            chuyenTrangMuonTra.setVisible(true);
            a3.setVisible(false);
        }
    }
    
    @FXML private void xuLyCaiDat(MouseEvent event){
        if(event.getTarget() == chucNang1 || event.getTarget() == chucNang2 )
        {
            chuyenTrangCaiDat.setVisible(true);
            a4.setVisible(false);
        }
    }
    //Cac nut back
    @FXML private AnchorPane trangChu;
    @FXML private ImageView troVe, troVe1, troVe2, troVe3;
    @FXML private void quayLai(MouseEvent event){
        if(event.getTarget() == troVe )
        {
            trangChu.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
            trangTheLoaiSach.setVisible(false);
            
        }
        if(event.getTarget() == troVe1)
        {
            trangChu.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
            trangQuanLyDocGia.setVisible(false);
            trangTheLoaiSach.setVisible(false);//nếu không đóng thì lúc back của danh mục sẽ còn cái trangTheLoaiSach
        }
        if(event.getTarget() == troVe2)
        {
            trangChu.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if(event.getTarget() == troVe3)
        {
            trangChu.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
    }
    
    //Thoat
    public void Thoat(ActionEvent event){
       System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
