/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CustomerDAO;
import Model.Customer;
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
public class LoginController implements Initializable, ControlledScreen {

    CustomerDAO customerDAO;
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
        customerDAO = new CustomerDAO();
    }

    @FXML
    private void Login(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        try {
            Customer is = customerDAO.getOne(username, password);
            if (is != null) {
                MyData.customer=is;
                myController.setScreen(Store.MenuID);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid Entered Data");
                alert.setHeaderText("Look, an Warning Dialog");
                alert.setContentText("Invalid username or password !\n please Enter Valid data or Register new Account");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }

    }

    @FXML
    private void Register(ActionEvent event) {
        myController.setScreen(Store.RegisterID);
    }

    @FXML
    private void AdminLogin(ActionEvent event) {
        myController.setScreen(Store.LoginAdminID);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

}
