package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import store.MyData;
import store.Store;


public class MenuController implements Initializable, ControlledScreen {


    private ScreensController myController;
    @FXML
    private Label nameLBL;

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
       // myController.loadScreen(Store.ShowProductID, Store.ShowProductFile);
        myController.setScreen(Store.ShowProductID);
    }

    @FXML
    private void takeOrder(ActionEvent event) {
        System.out.println("--- "+Store.MakeOrderID);
        myController.setScreen(Store.MakeOrderID);
    }

    @FXML
    private void logOut(ActionEvent event) {
        myController.setScreen(Store.LoginID);
    }
    
}
