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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import store.Store;

/**
 * FXML Controller class
 *
 * @author elkat
 */
public class RegisterController implements Initializable, ControlledScreen {

    
    CustomerDAO customerDAO;
    @FXML
    private TextField usernameTF, fullNameTF, emailTF, addressTF, phoneTF;
    @FXML
    private PasswordField passwordTF;
    private ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerDAO=new CustomerDAO();
    }    

    @FXML
    private void Register(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Customer c=new Customer(usernameTF.getText(), passwordTF.getText(), fullNameTF.getText(), addressTF.getText(), phoneTF.getText(), emailTF.getText());
        try {
            customerDAO.insert(c);
            myController.setScreen(Store.LoginID);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Registeration Complete!");
            alert.setHeaderText("Thanks for being part of us");
            alert.setContentText(null);
            alert.show();
        } catch (Exception ex) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Thanks for being part of us");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
    }

    @FXML
    private void Login(ActionEvent event) {
        myController.setScreen(Store.LoginID);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
