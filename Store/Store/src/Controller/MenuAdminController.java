package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import store.Store;


public class MenuAdminController implements Initializable, ControlledScreen {

    private ScreensController myController;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    @FXML
    private void showProduct(ActionEvent event) {
        myController.setScreen(Store.ShowProductAdminID);
    }

    @FXML
    private void showCustomer(ActionEvent event) {
        myController.setScreen(Store.ShowCustomerID);
    }

    @FXML
    private void logOut(ActionEvent event) {
        myController.setScreen(Store.LoginAdminID);
    }
    
}
