/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class DangNhapController implements Initializable {
    @FXML private ImageView close;
    @FXML
    private AnchorPane DangNhap;
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
    @FXML private Button btnDangNhap, btnNguoiDung;
    
    //hàm chuyển nếu đăng nhập thành công
    private double xOffset, yOffset;
    
    public void newWindow(String tenTrang) throws Exception{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(tenTrang));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        stage.setScene(scene);
        stage.show();
    }
    
   
    
    
    @FXML private void kiemTra(KeyEvent e){
        if(tenDangNhap.getText().length() > 45 || matKhau.getText().length() > 45){
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setHeaderText("Quá dài!!");
                alert1.showAndWait();
        }
    }
    
    @FXML private void dangNhap (ActionEvent event) throws Exception{
        if(event.getTarget() == btnDangNhap)
        {
            Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Đăng nhập");
            if(tenDangNhap.getText().equals("a") && matKhau.getText().equals("1"))
            {
                alert1.setHeaderText("Đăng nhập thành công!!!");
                alert1.showAndWait();
                newWindow("TrangChu.fxml");
            }
            else
            {
                alert1.setHeaderText("Tài khoản hoặc mặt khẩu không đúng!!!");   
                alert1.showAndWait();
            }
        }
        if(event.getTarget() == btnNguoiDung)
            newWindow("NguoiDung.fxml");
            
            
    }
    
    @FXML
    public void Enter(KeyEvent event) throws IOException, Exception{
        if(event.getCode() == KeyCode.ENTER)
        {
            Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Đăng nhập");
                if(tenDangNhap.getText().length() <= 45 || matKhau.getText().length() <= 45){
                    
                    if(tenDangNhap.getText().equals("a") && matKhau.getText().equals("1"))
                    {
                        alert1.setHeaderText("Đăng nhập thành công!!!");
                        alert1.showAndWait();
                        newWindow("TrangChu.fxml");
                    }
                    else
                    {
                        alert1.setHeaderText("Tài khoản hoặc mặt khẩu không đúng!!!");   
                        alert1.showAndWait();
                    }
                }
                else
                {
                    alert1.setHeaderText("Vượt quá độ dài cho phép!!!");   
                    alert1.showAndWait();
                }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}