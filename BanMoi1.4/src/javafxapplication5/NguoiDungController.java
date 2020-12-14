/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;


import com.tbn.services.SachServices;
import java.net.URL;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
        @FXML ImageView close;
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
       
   
       
       
 private void loadTS(String kw) {
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
           txtKW.setPromptText(op.getValue());
           if(null != op.getValue())
           switch (op.getValue()) {
               case "Tên sách":
                   txtKW.textProperty().addListener(evt ->{
                       loadTS(txtKW.getText());
                   });    break;
               case "Năm xuất bản":
                   txtKW.textProperty().addListener(evt ->{
                       loadNXB(txtKW.getText());
                   });    break;
               case "Mô tả sách":
                   txtKW.textProperty().addListener(evt ->{
                       loadTL(txtKW.getText());
                   });    break;
               default:
                   break;
           }
       }
    }
       public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
}
      @FXML public void kt(KeyEvent event){
           if("Năm xuất bản".equals(op.getValue()))
           {
               if(!isNumeric(event.getText()))
               {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Lỗi nhập số");
                    alert1.setHeaderText("Bạn vui lòng chỉ nhập số");
                        alert1.show();
               }
           }
               
       }
       @FXML private void thoat(MouseEvent event){
        
        if(event.getTarget() == close)
        {
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Bạn có muốn thoát không?",ButtonType.OK, ButtonType.CLOSE);
           alert.setTitle("Thoat");
           alert.setHeaderText("Thoát");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
                System.exit(0);
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
        loadTS("");
        loadNXB("");
        loadTL("");
    }    
    
}