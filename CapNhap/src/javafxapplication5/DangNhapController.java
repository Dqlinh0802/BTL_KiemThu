/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class DangNhapController implements Initializable {
    @FXML private ImageView close;
    @FXML private void thoat(MouseEvent event){
        
        if(event.getTarget() == close)
        {
           Alert alert = new Alert(AlertType.CONFIRMATION, "Bạn có muốn thoát không?",ButtonType.OK, ButtonType.CLOSE);
           alert.setTitle("Thoat");
           alert.setHeaderText("Thoát");
           Optional<ButtonType> result = alert.showAndWait();
           if(result.get() == ButtonType.OK)
                System.exit(0);
        }
    }
    
    @FXML private TextField tenDangNhap;
    @FXML private PasswordField matKhau;
    @FXML private Button btnDangNhap;
    @FXML private void dangNhap (ActionEvent event){
        if(event.getTarget() == btnDangNhap)
        {
            Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Đăng nhập");
            if(tenDangNhap.getText().equals("admin") && matKhau.getText().equals("123456789"))
            {
                alert1.setHeaderText("Đăng nhập thành công!!!");
                alert1.showAndWait();
            }
            else
            {
                alert1.setHeaderText("Tài khoản hoặc mặt khẩu không đúng!!!");   
                alert1.showAndWait();
            }
        }
    }
    public void Enter(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER)
        {
            Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Đăng nhập");
            if(tenDangNhap.getText().equals("admin") && matKhau.getText().equals("123456789"))
            {
                alert1.setHeaderText("Đăng nhập thành công!!!");
                alert1.showAndWait();
            }
            else
            {
                alert1.setHeaderText("Tài khoản hoặc mặt khẩu không đúng!!!");   
                alert1.showAndWait();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
