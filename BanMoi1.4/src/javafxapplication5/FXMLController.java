/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import com.tbn.pojo.DocGia;
import com.tbn.pojo.NhanVien;
import com.tbn.pojo.Sach;
import com.tbn.pojo.TheLoaiSach;
import com.tbn.services.DocGiaServices;
import com.tbn.services.NhanVienServices;
import com.tbn.services.SachServices;
import com.tbn.services.TheLoaiSachServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLController implements Initializable {

    @FXML
    private ImageView danhMuc, nguoiDung, muonTra, caiDat;
    @FXML
    private AnchorPane a1, a2, a3, a4;

    //bắt sự kiện chọn các mục ban đầu
    @FXML
    private void handleButtonAction(MouseEvent event) {
        if (event.getTarget() == danhMuc) {
            a1.setVisible(true);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(false);
        } else if (event.getTarget() == nguoiDung) {
            a1.setVisible(false);
            a2.setVisible(true);
            a3.setVisible(false);
            a4.setVisible(false);
        } else if (event.getTarget() == muonTra) {
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(true);
            a4.setVisible(false);
        } else if (event.getTarget() == caiDat) {
            a1.setVisible(false);
            a2.setVisible(false);
            a3.setVisible(false);
            a4.setVisible(true);
        }
    }
    
    @FXML
    private ImageView cacDauSach, theLoaiSach, nhanVien, QLDocGia;
    @FXML
    private ImageView muonSach, traSach, chucNang1, chucNang2;
    @FXML
    private ImageView danhMucNho1, danhMucNho2, danhMucNho3;
    @FXML
    private ImageView nguoiDungNho1, nguoiDungNho2, nguoiDungNho3;
    @FXML
    private ImageView muonTraNho1, muonTraNho2, muonTraNho3;
    @FXML
    private ImageView caiDatNho1, caiDatNho2, caiDatNho3;
    @FXML
    private AnchorPane chuyenTrangDanhMuc, chuyenTrangNguoiDung, chuyenTrangMuonTra, chuyenTrangCaiDat;
    @FXML
    private AnchorPane trangCacDauSach, trangTheLoaiSach;
    @FXML
    private AnchorPane trangNhanVien, trangQLDocGia, trangMuonSach, trangTraSach, trangChucNang1, trangChucNang2;
    @FXML
    private AnchorPane thanhCongCu1;
    @FXML
    private ImageView cacDauSach_1, theLoaiSach_1, nhanVien_1, QLDocGia_1;
    @FXML
    private ImageView muonSach_1, traSach_1, chucNang1_1, chucNang2_1;

    private void dongTatCaTab() {
        trangCacDauSach.setVisible(false);
        trangTheLoaiSach.setVisible(false);
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
        thanhThemSach.setVisible(false);
    }

    //trong phần danh mục
    @FXML
    private void xuLyDanhMuc(MouseEvent event) {
        dongTatCaTab();
        if (event.getTarget() == cacDauSach || event.getTarget() == cacDauSach_1) {
            thanhCongCu1.setVisible(true);
            chuyenTrangDanhMuc.setVisible(true);
            trangCacDauSach.setVisible(true);
        }
        if (event.getTarget() == theLoaiSach || event.getTarget() == theLoaiSach_1) {
            chuyenTrangDanhMuc.setVisible(true);
            trangTheLoaiSach.setVisible(true);
        }
        if (event.getTarget() == nguoiDungNho1) {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
        if (event.getTarget() == muonTraNho1) {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
        if (event.getTarget() == caiDatNho1) {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);
        }
    }

    //trong phần người dùng
    @FXML
    private void xuLyNguoiDung(MouseEvent event) {
        dongTatCaTab();
        if (event.getTarget() == nhanVien || event.getTarget() == nhanVien_1) {
            chuyenTrangNguoiDung.setVisible(true);
            trangNhanVien.setVisible(true);
        }
        if (event.getTarget() == QLDocGia || event.getTarget() == QLDocGia_1) {
            chuyenTrangNguoiDung.setVisible(true);
            trangQLDocGia.setVisible(true);
        }
        if (event.getTarget() == danhMucNho1) {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
        if (event.getTarget() == muonTraNho2) {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
        if (event.getTarget() == caiDatNho2) {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
    }

    //trong phần mượn trả
    @FXML
    private void xuLyMuonTra(MouseEvent event) {
        dongTatCaTab();
        if (event.getTarget() == muonSach || event.getTarget() == muonSach_1) {
            chuyenTrangMuonTra.setVisible(true);
            a3.setVisible(false);
            trangMuonSach.setVisible(true);
        }
        if (event.getTarget() == traSach || event.getTarget() == traSach_1) {
            chuyenTrangMuonTra.setVisible(true);
            a3.setVisible(false);
            trangTraSach.setVisible(true);
        }
        if (event.getTarget() == danhMucNho2) {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if (event.getTarget() == nguoiDungNho2) {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if (event.getTarget() == caiDatNho3) {
            chuyenTrangCaiDat.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
    }

    //trong mục cài đặt
    @FXML
    private void xuLyCaiDat(MouseEvent event) {
        dongTatCaTab();
        if (event.getTarget() == chucNang1 || event.getTarget() == chucNang1_1) {
            chuyenTrangCaiDat.setVisible(true);
            a4.setVisible(false);
            trangChucNang1.setVisible(true);
        }
        if (event.getTarget() == chucNang2 || event.getTarget() == chucNang2_1) {
            chuyenTrangCaiDat.setVisible(true);
            a4.setVisible(false);
            trangChucNang2.setVisible(true);
        }
        if (event.getTarget() == danhMucNho3) {
            chuyenTrangDanhMuc.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
        if (event.getTarget() == nguoiDungNho3) {
            chuyenTrangNguoiDung.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
        if (event.getTarget() == muonTraNho3) {
            chuyenTrangMuonTra.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
    }

    //khung mục tìm sách và bật/tắt khung
    @FXML
    private ImageView iconTimSach;
    @FXML
    private AnchorPane thanhTimKiem;
    @FXML
    TextField txtKeyword, txtKeyword1;
    private boolean co1 = true;

    //khung mục tìm sách và bật/tắt khung
    @FXML
    private void timSach(MouseEvent event) {
        if (event.getTarget() == iconTimSach) {
            if (co1 == true) {
                thanhTimKiem.setVisible(true);
                co1 = false;
            } else {
                thanhTimKiem.setVisible(false);
                co1 = true;
            }
        }
    }

    @FXML
    private ImageView iconThemSach;
    @FXML
    private AnchorPane thanhThemSach;
    private boolean co2 = true;
    @FXML
    private ImageView iconSuaSach;
    @FXML
    private AnchorPane thanhSuaSach;
    private boolean co3 = true;

    //khung mục thêm sách và bật/tắt
    @FXML
    private void themSach(MouseEvent event) {
        if (event.getTarget() == iconThemSach) {
            if (co2 == true) {
                thanhThemSach.setVisible(true);
                thanhSuaSach.setVisible(false);
                co2 = false;
            } else {
                thanhThemSach.setVisible(false);
                co2 = true;
            }
        }
    }

    //khung sửa sách bật/tắt
    @FXML
    private void suaSach(MouseEvent event) {
        if (event.getTarget() == iconSuaSach) {
            if (co3 == true) {
                thanhSuaSach.setVisible(true);
                thanhThemSach.setVisible(false);
                co3 = false;
            } else {
                thanhSuaSach.setVisible(false);
                co3 = true;
            }
        }
    }

    //Hủy thao tác sửa thông tin
    @FXML
    private Button btSua, btThem;

    public void ganVeNull1() {

        //gán bằng null cho các trường sửa
        txtMaSachSua.setText("");
        txtTenSachSua.setText("");
        txtSoLuongSua.setText("");
        txtNamXuatBanSua.setText("");
        txtMoTaSua.setText("");

        //đóng các trường nhập và tắt nút sửa
        btSua.setDisable(true);
        txtMaSachSua.setDisable(true);
        txtTenSachSua.setDisable(true);
        txtSoLuongSua.setDisable(true);
        txtNamXuatBanSua.setDisable(true);
        txtMoTaSua.setDisable(true);

    }

    public void ganVeNull2() {

        //gán bằng null cho các trường thêm
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtSoLuong.setText("");
        txtNamXuatBan.setText("");
        txtMoTa.setText("");
    }

    public void ganVeNull3() {

        //gán bằng null cho các trường thêm
        txtMaDocGia.setText("");
        txtTenDocGia.setText("");
        txtDoiTuong.setText("");
        txtBoPhan.setText("");
        txtNgayDangKy.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        ckNam.setSelected(false);
        ckNu.setSelected(false);
    }
    public void ganVeNull4() {

        //gán bằng null cho các trường thêm
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtMatKhau.setText("");
        txtTenDangNhap.setText("");
        txtEmailNV.setText("");
        txtSDTNV.setText("");
        txtDiaChiNV.setText("");
        ckNamNV.setSelected(false);
        ckNuNV.setSelected(false);
        
    }
    
    @FXML
    public void Huy(ActionEvent evt) {
        ganVeNull1();
        cbTheLoaiSach1.getSelectionModel().clearSelection();
    }

    @FXML
    public void Huy1(ActionEvent evt) {
        ganVeNull2();
        cbTheLoaiSach.getSelectionModel().clearSelection();
    }

    @FXML
    public void Huy3(ActionEvent evt) {
        txtMaLoaiSach.setText("");
        txtTenLoaiSach.setText("");
    }
    
    @FXML
    public void Huy4(ActionEvent evt) {
        ganVeNull3();
    }
    
    
    //kiểm tra nhập số
    @FXML private void kiemTraNhapSo(KeyEvent e){
        if(!(e.getCode().isDigitKey() || e.getCode() == KeyCode.BACK_SPACE)){
           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText("Không nhập chữ");
                alert1.showAndWait();
        }
        if(txtNamXuatBan.getText().length() > 3)
        {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText("Không cho phép nhập quá 4 chữ số");
                alert1.showAndWait();
        }
    }
    
    
//    kiểm tra 
//    @FXML private void kiemTraNhap(KeyEvent e){
//        if(){
//           Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//            alert1.setHeaderText("Không nhập chữ");
//                alert1.showAndWait();
//        }   
//    }
    

    //Thêm sách
    @FXML
    TextField txtMaSach, txtTenSach, txtSoLuong, txtNamXuatBan, txtMoTa;
    @FXML
    private ComboBox<TheLoaiSach> cbTheLoaiSach;
    @FXML
    private ComboBox<TheLoaiSach> cbTheLoaiSach1;

    @FXML
    public void themSachHandler(ActionEvent evt) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if((txtMaSach.getText().trim().equals("")) || (txtTenSach.getText().trim().equals(""))){
            alert.setContentText("Mã sách trống hoặc tên sách trống");
            alert.show();
            return;
        }
        else if(!(txtMaSach.getText().trim().equals("") && txtTenSach.getText().trim().equals(""))){
            if (cbTheLoaiSach.getSelectionModel().getSelectedItem() == null) {
                alert.setContentText("Bạn chưa chọn thể loại");
                alert.show();
                return;
            }

            Sach q = new Sach(txtMaSach.getText(), txtTenSach.getText(),
                    Integer.parseInt(txtSoLuong.getText()), txtNamXuatBan.getText(), txtMoTa.getText(),
                    cbTheLoaiSach.getSelectionModel().getSelectedItem());

            if (SachServices.addSach(q) == true) {
                alert.setContentText("SUCCESSFUL");
                loadSach("");
                ganVeNull2();
            } else {
                alert.setContentText("FAILED");
            }
            alert.show(); 
        }
        
        
    }

    //Thêm thể loại sách
    @FXML
    TextField txtTenLoaiSach, txtMaLoaiSach;

    @FXML
    public void themLoaiSachHandler(ActionEvent evt) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if((txtMaSach.getText().trim().equals("") && txtTenSach.getText().trim().equals(""))){
            TheLoaiSach t = new TheLoaiSach(Integer.parseInt(txtMaLoaiSach.getText()), txtTenLoaiSach.getText());
            
            if(txtMaLoaiSach.getText().trim() !=  null && txtTenLoaiSach.getText().trim() != null){
                if (TheLoaiSachServices.addTheLoaiSach(t) == true) {
                    alert.setContentText("SUCCESSFUL");

                    loadTheLoaiSach("");

                    txtMaLoaiSach.setText("");
                    txtTenLoaiSach.setText("");

                } else {
                    alert.setContentText("FAILED");
                }
                alert.show();
            }
        }
        if(!(txtMaSach.getText().trim().equals("")) || !(txtTenSach.getText().trim().equals(""))){
            alert.setContentText("Mã sách trống hoặc tên sách trống");
            alert.show();
        }
            
    }

    //Sửa sách
    @FXML
    TextField txtMaSachSua, txtTenSachSua, txtSoLuongSua, txtNamXuatBanSua, txtMoTaSua;// nếu bug sửa txtMa

    @FXML
    public void suaSachHandler(ActionEvent evt) throws SQLException {
        Sach q = new Sach(txtMaSachSua.getText(), txtTenSachSua.getText(),
                Integer.parseInt(txtSoLuongSua.getText()), txtNamXuatBanSua.getText(),
                txtMoTaSua.getText(), cbTheLoaiSach1.getValue());

        //Thêm phần dưới nếu bug sửa
        //TheLoaiSachServices.getTheLoaiSachByID(Integer.parseInt(txtMa.getText())
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            if (SachServices.deleteSach(q.getMaSach()) == true) {
                SachServices.addSach(q);
                alert.setContentText("SUCCESSFUL");

                loadSach("");
                ganVeNull1();

            } else {
                alert.setContentText("FAILED");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        alert.show();

    }
    
    

    //Thêm độc giả
    @FXML
    public void themDocGiaHandler(ActionEvent evt) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        String gioiTinh;
        if(ckNam.isSelected())
                gioiTinh = "nam";
        else
                gioiTinh = "nu";
            
        
        DocGia q = new DocGia(txtMaDocGia.getText(), txtTenDocGia.getText()
                , gioiTinh, ngaySinh.getValue().toString(), txtDoiTuong.getText(), txtBoPhan.getText(),
                txtNgayDangKy.getText(), txtEmail.getText(),  txtSDT.getText(), txtDiaChi.getText());

        if (DocGiaServices.addDocGia(q) == true) {
            alert.setContentText("SUCCESSFUL");
            loadDocGia("");
            ganVeNull3();
        } else {
            alert.setContentText("FAILED");
        }
        alert.show();
    }
    
    //Thêm nhân viên
    @FXML
    public void themNVHandler(ActionEvent evt) {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        String gioiTinh1;
        if(ckNamNV.isSelected())
                gioiTinh1 = "nam";
        else
                gioiTinh1 = "nu";
        
        NhanVien q = new NhanVien(txtMaNV.getText(), txtTenNV.getText(), gioiTinh1
                , ngaySinhNV.getValue().toString(), txtEmailNV.getText(), txtDiaChiNV.getText()
                , txtSDTNV.getText(), txtTenDangNhap.getText(), txtMatKhau.getText());

        if (NhanVienServices.addNV(q) == true) {
            alert.setContentText("SUCCESSFUL");
            loadNV("");
            ganVeNull4();
        } else {
            alert.setContentText("FAILED");
        }
        alert.show();
    }
    
    //Cac nut back
    @FXML
    private AnchorPane trangChu;
    @FXML
    private ImageView troVe, troVe1, troVe2, troVe3;

    @FXML
    private void quayLai(MouseEvent event) {
        dongTatCaTab();
        if (event.getTarget() == troVe) {
            trangChu.setVisible(true);
            chuyenTrangDanhMuc.setVisible(false);

        }
        if (event.getTarget() == troVe1) {
            trangChu.setVisible(true);
            chuyenTrangNguoiDung.setVisible(false);
        }
        if (event.getTarget() == troVe2) {
            trangChu.setVisible(true);
            chuyenTrangMuonTra.setVisible(false);
        }
        if (event.getTarget() == troVe3) {
            trangChu.setVisible(true);
            chuyenTrangCaiDat.setVisible(false);
        }
    }

    @FXML
    private TableView bang;

    //hiện bảng sach
    private void buildTable() throws SQLException {
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
        TableColumn colLoaiSach = new TableColumn("");
        colLoaiSach.setCellValueFactory(new PropertyValueFactory("theLoaiSach"));

        //Xóa thông tin sách
        TableColumn colXoa = new TableColumn();
        colXoa.setCellFactory(evt -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Xóa");
            btn.setOnMouseClicked(et -> {
                Button b = (Button) et.getSource();
                TableCell c = (TableCell) b.getParent();
                Sach q = (Sach) c.getTableRow().getItem();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Bạn thật sự muốn xóa???");
                alert.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.OK) {
                        try {
                            if (SachServices.deleteSach(q.getMaSach()) == true) {
                                loadSach("");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            });
            cell.setGraphic(btn);

            return cell;
        });
        //chuyển thông tin sách cần sửa 
        TableColumn colSua = new TableColumn();
        colSua.setCellFactory(evt -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Sửa");
            btn.setOnMouseClicked(et -> {

                loadSach("");

                Button b = (Button) et.getSource();
                TableCell c = (TableCell) b.getParent();
                Sach q = (Sach) c.getTableRow().getItem();
                txtMaSachSua.setText(q.getMaSach());
                txtTenSachSua.setText(q.getTenSach());
                txtSoLuongSua.setText(String.valueOf(q.getSoLuong()));
                txtNamXuatBanSua.setText(q.getNamXuatBan());
                txtMoTaSua.setText(q.getMoTaSach());
                cbTheLoaiSach1.getSelectionModel().select(q.getTheLoaiSach().getId() - 1);
                // có trừ 1 vì getid lấy mã còn select thì từ 0

                thanhSuaSach.setVisible(true);
                co3 = false;
                thanhThemSach.setVisible(false);

                //bật các trường nhập và nút sửa  
                btSua.setDisable(false);
                txtMaSachSua.setDisable(false);
                txtTenSachSua.setDisable(false);
                txtSoLuongSua.setDisable(false);
                txtNamXuatBanSua.setDisable(false);
                txtMoTaSua.setDisable(false);

            });
            cell.setGraphic(btn);

            return cell;
        });

        //độ rộng các cột
        bang.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaSach.setMaxWidth(1f * Integer.MAX_VALUE * 10); // 10% width
        colTenSach.setMaxWidth(1f * Integer.MAX_VALUE * 25); // 25% width
        colSoLuong.setMaxWidth(1f * Integer.MAX_VALUE * 10); // 10% width
        colNamXuatBan.setMaxWidth(1f * Integer.MAX_VALUE * 16); // 16% width
        colMoTaSach.setMaxWidth(1f * Integer.MAX_VALUE * 25); // 28% width
        colXoa.setMaxWidth(1f * Integer.MAX_VALUE * 7); // 7% width
        colSua.setMaxWidth(1f * Integer.MAX_VALUE * 7); // 7% width
        colLoaiSach.setMaxWidth(1f * Integer.MAX_VALUE * 0);
        bang.getColumns().addAll(colMaSach, colTenSach, colSoLuong, colNamXuatBan, colMoTaSach, colXoa, colSua, colLoaiSach);
    }

    // load sách
    private void loadSach(String kw) {
        try {
            bang.setItems(FXCollections.observableArrayList(SachServices.getSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private TableView bangTheLoai;

    //hiện bảng thể loại sách
    private void buildTable1() throws SQLException {
        TableColumn colMaLoaiSach = new TableColumn("Mã thể loại sách");
        colMaLoaiSach.setCellValueFactory(new PropertyValueFactory("id"));// ben class TheLoaiSach.java
        TableColumn colTenLoaiSach = new TableColumn("Tên loại sách");
        colTenLoaiSach.setCellValueFactory(new PropertyValueFactory("tenLoaiSach"));// ben class TheLoaiSach.javas

        //độ rộng các cột
        bangTheLoai.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaLoaiSach.setMaxWidth(1f * Integer.MAX_VALUE * 20);
        colTenLoaiSach.setMaxWidth(1f * Integer.MAX_VALUE * 50);

        bangTheLoai.getColumns().addAll(colMaLoaiSach, colTenLoaiSach);
    }

    // loadSach the loai sach
    private void loadTheLoaiSach(String kw) {
        try {
            bangTheLoai.setItems(FXCollections.observableArrayList(TheLoaiSachServices.getTheLoaiSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @FXML
    private TableView bangNV;

    //hiện bảng thể loại sách
    private void buildTable2() throws SQLException {
        TableColumn colMaNV = new TableColumn("Mã nhân viên");
        colMaNV.setCellValueFactory(new PropertyValueFactory("maNV"));// ben class NhanVien.java
        TableColumn colTenNV = new TableColumn("Tên nhân viên");
        colTenNV.setCellValueFactory(new PropertyValueFactory("tenNV"));// ben class NhanVien.javas
        TableColumn colGioiTinh = new TableColumn("Giới tính");
        colGioiTinh.setCellValueFactory(new PropertyValueFactory("gioiTinh"));// ben class NhanVien.java
        TableColumn colSDT = new TableColumn("Số điện thoại");
        colSDT.setCellValueFactory(new PropertyValueFactory("sdt"));// ben class NhanVien.java

        //độ rộng các cột
        bangNV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaNV.setMaxWidth(1f * Integer.MAX_VALUE * 25);
        colTenNV.setMaxWidth(1f * Integer.MAX_VALUE * 25);
        colGioiTinh.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        colSDT.setMaxWidth(1f * Integer.MAX_VALUE * 35);
        
        bangNV.getColumns().addAll(colMaNV, colTenNV, colGioiTinh, colSDT);
    }

    // loadNV the loai sach
    private void loadNV(String kw) {
        try {
            bangNV.setItems(FXCollections.observableArrayList(NhanVienServices.getNhanVien(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private TableView bangDocGia;

    //hiện bảng thể loại sách
    private void buildTable3() throws SQLException {
        TableColumn colMaDocGia = new TableColumn("Mã độc giả");
        colMaDocGia.setCellValueFactory(new PropertyValueFactory("maDocGia"));// ben class DocGia.java
        TableColumn colTenDocGia = new TableColumn("Tên độc giả");
        colTenDocGia.setCellValueFactory(new PropertyValueFactory("tenDocGia"));// ben class DocGia.javas
        TableColumn colDoiTuong = new TableColumn("Đối tượng");
        colDoiTuong.setCellValueFactory(new PropertyValueFactory("doiTuong"));// ben class DocGia.java
        TableColumn colBoPhan = new TableColumn("Bộ phận");
        colBoPhan.setCellValueFactory(new PropertyValueFactory("boPhan"));// ben class DocGia.java
        
        TableColumn colXoa = new TableColumn();
        colXoa.setCellFactory(evt -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Xóa");
            btn.setOnMouseClicked(et -> {
                Button b = (Button) et.getSource();
                TableCell c = (TableCell) b.getParent();
                DocGia q = (DocGia) c.getTableRow().getItem();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Bạn thật sự muốn xóa???");
                alert.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.OK) {
                        try {
                            if (DocGiaServices.deleteDocGia(q.getMaDocGia()) == true) {
                                loadDocGia("");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            });
            cell.setGraphic(btn);

            return cell;
        });

        //độ rộng các cột
        bangDocGia.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaDocGia.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        colTenDocGia.setMaxWidth(1f * Integer.MAX_VALUE * 25);
        colDoiTuong.setMaxWidth(1f * Integer.MAX_VALUE * 15);
        colBoPhan.setMaxWidth(1f * Integer.MAX_VALUE * 25);
        colXoa.setMaxWidth(1f * Integer.MAX_VALUE * 8);
        
        bangDocGia.getColumns().addAll(colMaDocGia, colTenDocGia, colDoiTuong, colBoPhan, colXoa);
    }

    // loadNV the loai sach
    private void loadDocGia(String kw) {
        try {
            bangDocGia.setItems(FXCollections.observableArrayList(DocGiaServices.getDocGia(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void buildTable4() throws SQLException {
        TableColumn colMaSach = new TableColumn("Mã sách");
        colMaSach.setCellValueFactory(new PropertyValueFactory("maSach"));// ben class Sach.java
        TableColumn colTenSach = new TableColumn("Tên sách");
        colTenSach.setCellValueFactory(new PropertyValueFactory("tenSach"));// ben class Sach.javas
        TableColumn colSoLuong = new TableColumn("Số lượng");
        colSoLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));// ben class Sach.javas

        //Mượn sách
        TableColumn colMuon = new TableColumn();
        colMuon.setCellFactory(evt -> {
            TableCell cell = new TableCell();
            Button btn = new Button("Mượn");
            btn.setOnMouseClicked(et -> {
                
                Button b = (Button) et.getSource();
                TableCell c = (TableCell) b.getParent();
                Sach q = (Sach) c.getTableRow().getItem();
                
                
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                

                alert.setContentText("Bạn muốn mượn quyển này???");
                alert.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.OK) {
                        if( q.getSoLuong() <= 0)
                        {
                            alert.setContentText("Số lượng sách đã hết!!!!!");
                            alert.show();
                            return;
                        }
                    else{
                        alert.setContentText("Bạn mượn thành công 1 cuốn sách!!!!!");
                        alert.show();    
                        loadMuon(q.getMaSach(), q.getSoLuong());
                        loadMuon_1("");
                        }
                    }
                });
            });
            cell.setGraphic(btn);

            return cell;
        });

        //độ rộng các cột
        bangMuonSach.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colMaSach.setMaxWidth(1f * Integer.MAX_VALUE * 20); // 10% width
        colTenSach.setMaxWidth(1f * Integer.MAX_VALUE * 25); // 25% width
        colSoLuong.setMaxWidth(1f * Integer.MAX_VALUE * 20); // 10% width
        colMuon.setMaxWidth(1f * Integer.MAX_VALUE * 15); // 7% width
        
        bangMuonSach.getColumns().addAll(colMaSach, colTenSach, colSoLuong, colMuon);
    }
    
    @FXML
    private TableView bangMuonSach;
    // loadMuon sach
    private void loadMuon(String kw, int sl) {
        
        try {
            SachServices.muon(kw, sl);
            bangMuonSach.setItems(FXCollections.observableArrayList(SachServices.getSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadMuon_1(String kw) {
        
        try {
            bangMuonSach.setItems(FXCollections.observableArrayList(SachServices.getSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    TextField txtMaDocGia, txtTenDocGia, txtEmail, txtDoiTuong, txtBoPhan, txtDiaChi, txtSDT, txtNgayDangKy;
    @FXML
    TextField txtMaNV, txtTenNV, txtEmailNV, txtTenDangNhap, txtMatKhau, txtDiaChiNV, txtSDTNV;
    @FXML
    CheckBox  ckNam, ckNu;
    @FXML
    DatePicker ngaySinh, ngaySinhNV;
    
    @FXML
    private void ActionNam(ActionEvent evt) {
        if(ckNam.isSelected() == true){
            ckNam.setSelected(true);
            ckNu.setSelected(false);
        }
    }
    
    @FXML
    private void ActionNu(ActionEvent evt) {
        if(ckNu.isSelected() == true){
            ckNu.setSelected(true);
            ckNam.setSelected(false);
        }
    }
    
    @FXML
    CheckBox  ckNamNV, ckNuNV;
    @FXML
    private void ActionNamNV(ActionEvent evt) {
        if(ckNamNV.isSelected() == true){
            ckNamNV.setSelected(true);
            ckNuNV.setSelected(false);
        }
    }
    
    @FXML
    private void ActionNuNV(ActionEvent evt) {
        if(ckNuNV.isSelected() == true){
            ckNuNV.setSelected(true);
            ckNamNV.setSelected(false);
        }
        
    }
    @FXML
    private ImageView themDocGia;
    @FXML 
    private AnchorPane thanhThemSach111;
    boolean co4 = false;  
    @FXML
    private void ActionThemDocGia(MouseEvent event) {
        if (event.getTarget() == themDocGia) {
            if (co4 == true) {
                thanhThemSach111.setVisible(true);
                co4 = false;
            }
            else{
                thanhThemSach111.setVisible(false);
                co4 = true;
            }
        }
    }
    
    //Thoat
    @FXML
    private ImageView close;

    @FXML
    private void thoat(MouseEvent event) {
        if (event.getTarget() == close) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bạn có muốn thoát không?", ButtonType.OK, ButtonType.CLOSE);
            alert.setTitle("Thoat");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // TODO
            buildTable();
            loadSach("");
            cbTheLoaiSach.getItems().addAll(TheLoaiSachServices.getTheLoaiSach(""));
            cbTheLoaiSach1.getItems().addAll(TheLoaiSachServices.getTheLoaiSach(""));

            buildTable1();
            loadTheLoaiSach("");
            
            buildTable2();
            loadNV("");
            
            buildTable3();
            loadDocGia("");
            
            buildTable4();
            loadMuon("",0);
            loadMuon_1("");
            
            txtKeyword.textProperty().addListener(evt -> {
                loadSach(txtKeyword.getText());
            });
            
            txtKeyword1.textProperty().addListener(evt -> {
                loadTheLoaiSach(txtKeyword1.getText());
            });
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
