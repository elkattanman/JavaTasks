/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import store.MyData;
import store.Store;

/**
 * FXML Controller class
 *
 * @author elkat
 */
public class LoginAdminController implements Initializable, ControlledScreen {

    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    private ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        String username=usernameTF.getText().trim().toLowerCase();
        String password=passwordTF.getText().trim().toLowerCase();
        if(username.equals(MyData.admin.getUserName()) && password.equals(MyData.admin.getPassword())){
            myController.setScreen(Store.MenuAdminID);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("invalid data");
            alert.setHeaderText("Look, an warning Dialog");
            alert.setContentText("invalid Username or password!\n please Enter Correct username and password");
            alert.showAndWait();
        }
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void UserLogin(ActionEvent event) {
        myController.setScreen(Store.LoginID);
    }
    
}
