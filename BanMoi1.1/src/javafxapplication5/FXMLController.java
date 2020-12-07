/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;


import com.tbn.services.SachServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLController implements Initializable {

    @FXML private ImageView danhMuc, nguoiDung, muonTra, caiDat;
    @FXML private AnchorPane a1, a2, a3, a4;
    
    //bắt sự kiện chọn các mục ban đầu
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
    @FXML private ImageView danhMucNho1, danhMucNho2, danhMucNho3;
    @FXML private ImageView nguoiDungNho1, nguoiDungNho2, nguoiDungNho3;
    @FXML private ImageView muonTraNho1, muonTraNho2, muonTraNho3;
    @FXML private ImageView caiDatNho1, caiDatNho2, caiDatNho3;
    @FXML private AnchorPane chuyenTrangDanhMuc, chuyenTrangNguoiDung, chuyenTrangMuonTra, chuyenTrangCaiDat;
    @FXML private AnchorPane trangTheLoaiSach, trangNgonNguSach, trangTacGia, trangNhaXuatBan, trangKeSach;
    @FXML private AnchorPane trangNhanVien, trangQLDocGia, trangMuonSach, trangTraSach, trangChucNang1, trangChucNang2;
    @FXML private AnchorPane thanhCongCu1;
    @FXML private ImageView theLoaiSach_1, ngonNguSach_1, tacGia_1, nhaXuatBan_1, keSach_1, nhanVien_1, QLDocGia_1;
    @FXML private ImageView muonSach_1, traSach_1, chucNang1_1, chucNang2_1;
    private void dongTatCaTab(){
        trangTheLoaiSach.setVisible(false);
        trangNgonNguSach.setVisible(false);
        trangTacGia.setVisible(false);
        trangTheLoaiSach.setVisible(false);
        trangNhaXuatBan.setVisible(false);
        trangKeSach.setVisible(false);
        trangNhanVien.setVisible(false);
        trangQLDocGia.setVisible(false);
        trangMuonSach.setVisible(false);
        trangTraSach.setVisible(false);
        trangChucNang1.setVisible(false);
        trangChucNang2.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        a3.setVisible(false);
        a4.setVisible(false);
        thanhCongCu1.setVisible(false);
        thanhTimKiem.setVisible(false);
    }
    
    //trong phần danh mục
    @FXML private void xuLyDanhMuc(MouseEvent event){
        dongTatCaTab();
        if(event.getTarget() == theLoaiSach || event.getTarget() == theLoaiSach_1)
        {
            thanhCongCu1.setVisible(true);
            chuyenTrangDanhMuc.setVisible(true);    
            trangTheLoaiSach.setVisible(true);
        }
        if(event.getTarget() == ngonNguSach ||event.getTarget() == ngonNguSach_1)
        {
            chuyenTrangDanhMuc.setVisible(true);
            trangNgonNguSach.setVisible(true);
        }
        if(event.getTarget() == tacGia || event.getTarget() == tacGia_1)
        {
            chuyenTrangDanhMuc.setVisible(true);
            trangTacGia.setVisible(true);
        }
        if(event.getTarget() == nhaXuatBan || event.getTarget() == nhaXuatBan_1)
        {
            chuyenTrangDanhMuc.setVisible(true);
            trangNhaXuatBan.setVisible(true);
        }
        if(event.getTarget() == keSach || event.getTarget() == keSach_1)
        {
            chuyenTrangDanhMuc.setVisible(true);
            trangKeSach.setVisible(true);
        }
        if(event.getTarget() == nguoiDungNho1)
        {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
        if(event.getTarget() == muonTraNho1)
        {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
        if(event.getTarget() == caiDatNho1)
        {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
    }
    
    //trong phần người dùng
    @FXML private void xuLyNguoiDung(MouseEvent event){
        dongTatCaTab();
        if(event.getTarget() == nhanVien || event.getTarget() == nhanVien_1)
        {
            chuyenTrangNguoiDung.setVisible(true);
            trangNhanVien.setVisible(true);
        }
        if(event.getTarget() == QLDocGia || event.getTarget() == QLDocGia_1)
        {
            chuyenTrangNguoiDung.setVisible(true);
            trangQLDocGia.setVisible(true);
        }
        if(event.getTarget() == danhMucNho1)
        {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
        if(event.getTarget() == muonTraNho2)
        {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
        if(event.getTarget() == caiDatNho2)
        {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
    }
    
    //trong phần mượn trả
    @FXML private void xuLyMuonTra(MouseEvent event){
        dongTatCaTab();
        if(event.getTarget() == muonSach || event.getTarget() == muonSach_1)
        {
            chuyenTrangMuonTra.setVisible(true);
            a3.setVisible(false);
            trangMuonSach.setVisible(true); 
        }
        if(event.getTarget() == traSach || event.getTarget() == traSach_1)
        {
            chuyenTrangMuonTra.setVisible(true);
            a3.setVisible(false);
            trangTraSach.setVisible(true);
        }
        if(event.getTarget() == danhMucNho2)
        {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if(event.getTarget() == nguoiDungNho2)
        {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if(event.getTarget() == caiDatNho3)
        {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
    }
    
    //trong mục cài đặt
    @FXML private void xuLyCaiDat(MouseEvent event){
        dongTatCaTab();
        if(event.getTarget() == chucNang1 || event.getTarget() == chucNang1_1)
        {
            chuyenTrangCaiDat.setVisible(true);
            a4.setVisible(false);
            trangChucNang1.setVisible(true);
        }
        if(event.getTarget() == chucNang2 || event.getTarget() == chucNang2_1)
        {
            chuyenTrangCaiDat.setVisible(true);
            a4.setVisible(false);
            trangChucNang2.setVisible(true);
        }
        if(event.getTarget() == danhMucNho3)
        {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
        if(event.getTarget() == nguoiDungNho3)
        {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
        if(event.getTarget() == muonTraNho3)
        {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
    }

    //khung mục tìm sách
    @FXML private ImageView timSach;
    @FXML private AnchorPane thanhTimKiem;
    @FXML TextField txtKeyword;
    private int dem = 0;
    @FXML private void timSach(MouseEvent event){
        dem++;
        if(event.getTarget() == timSach)
        {
            if(dem == 1)
                thanhTimKiem.setVisible(true);
            else
            {
                thanhTimKiem.setVisible(false);
                dem = 0;
            }
        }
    }
    //Cac nut back
    @FXML private AnchorPane trangChu;
    @FXML private ImageView troVe, troVe1, troVe2, troVe3;
    @FXML private void quayLai(MouseEvent event){
        dongTatCaTab();
        if(event.getTarget() == troVe )
        {
            trangChu.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
            
        }
        if(event.getTarget() == troVe1)
        {
            trangChu.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false); 
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
    
    @FXML private TableView bang;
    
    private void buildTable(){
        TableColumn colMaSach = new TableColumn("Mã sách");
        colMaSach.setCellValueFactory(new PropertyValueFactory("maSach"));// ben class Sach.java
        TableColumn colTenSach = new TableColumn("Tên sách");
        colTenSach.setCellValueFactory(new PropertyValueFactory("tenSach"));// ben class Sach.javas
        TableColumn colSoLuong = new TableColumn("Số lượng");
        colSoLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));// ben class Sach.javas
        TableColumn colNamXuatBan = new TableColumn("Năm xuất bản");
        colNamXuatBan.setCellValueFactory(new PropertyValueFactory("namXuatBan"));// ben class Sach.javas
        TableColumn colMoTaSach = new TableColumn("Mô tả sách");
        colMoTaSach.setCellValueFactory(new PropertyValueFactory("moTaSach"));// ben class Sach.javas
        
        //độ rộng các cột
        bang.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaSach.setMaxWidth(1f * Integer.MAX_VALUE * 7); // 7% width
        colTenSach.setMaxWidth(1f * Integer.MAX_VALUE * 28); // 28% width
        colSoLuong.setMaxWidth(1f * Integer.MAX_VALUE * 10); // 10% width
        colNamXuatBan.setMaxWidth(1f * Integer.MAX_VALUE * 15); // 15% width
        colMoTaSach.setMaxWidth(1f * Integer.MAX_VALUE * 40); // 40% width
        bang.getColumns().addAll(colMaSach, colTenSach, colSoLuong, colNamXuatBan, colMoTaSach);
        
    }
    private void load(String kw){
        try {
            bang.setItems(FXCollections.observableArrayList(SachServices.getSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Thoat
    @FXML private ImageView close;
    @FXML private void thoat(MouseEvent event){
       if(event.getTarget() == close)
        {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bạn có muốn thoát không?",ButtonType.OK, ButtonType.CLOSE);
           alert.setTitle("Thoat");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
                System.exit(0);
        }
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       buildTable();
       load("");
        txtKeyword.textProperty().addListener(evt -> {
            load(txtKeyword.getText());
        });

    }

    @FXML
    private void quayLai(TouchEvent event) {
    }
    
}
