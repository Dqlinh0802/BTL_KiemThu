/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;


import com.tbn.services.SachServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author win
 */
public class NguoiDungController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TableView bang_ND;
        @FXML public ComboBox<String> op;
        @FXML TextField txtKW;
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
       
        bang_ND.getColumns().addAll(colMaSach, colTenSach, colSoLuong, colNamXuatBan, colMoTaSach, colLoaiSach);
       }
       
     
       
       
           private void load(String kw) {
        try {
            bang_ND.setItems(FXCollections.observableArrayList(SachServices.getSach(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
                    private void loadNXB(String kw) {
        try {
            bang_ND.setItems(FXCollections.observableArrayList(SachServices.getNXB(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                             private void loadTL(String kw) {
        try {
            bang_ND.setItems(FXCollections.observableArrayList(SachServices.getTL(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       ObservableList<String> list = FXCollections.observableArrayList("Tên sách", "Năm xuất bản", "Mô tả sách");
       public void comboBoxChanged (ActionEvent event){
       if(op.getValue() != null)
       {
           txtKW.setVisible(true);
           if(null != op.getValue())
           switch (op.getValue()) {
               case "Tên sách":
                   txtKW.textProperty().addListener(evt ->{
                       load(op.getValue());
                   });    break;
               case "Năm xuất bản":
                   txtKW.textProperty().addListener(evt ->{
                       loadNXB(op.getValue());
                   });    break;
               case "Mô tả sách":
                   txtKW.textProperty().addListener(evt ->{
                       loadTL(op.getValue());
                   });    break;
               default:
                   break;
           }
       }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            buildTable();
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungController.class.getName()).log(Level.SEVERE, null, ex);
        }
        op.setItems(list);
        load("");
        loadNXB("");
        loadTL("");
    }    
    
}