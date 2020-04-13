/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Model.ORDEREDITEM;
import Model.Product;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import store.MyData;
import store.Store;

/**
 * FXML Controller class
 *
 * @author elkat
 */
public class MakeOrderController implements Initializable, ControlledScreen {

    private ProductDAO productDAO = new ProductDAO();

    @FXML
    private ComboBox<String> myList;
    private Map<String, Product> mp;
    @FXML
    private TextArea orders;
    private ScreensController mainController;
    @FXML
    private ComboBox<String> cnt;
    double total = 0;
    @FXML
    private TextField totalTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnt.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        productDAO = new ProductDAO();
        orders.appendText(String.format("%-20s %-4s %-6s$%n", "Name", "#","price"));
        mp = new HashMap<>();
        try {
            List<Product> all = productDAO.getAll();
            all.forEach((o) -> {
                mp.put(o.getName(), o);
                myList.getItems().add(o.getName());
            });
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
    private void order(ActionEvent event) {
        Product p = mp.get(myList.getValue());
        int q = Integer.parseInt(cnt.getValue());
        double x = Double.parseDouble(p.getPrice()) * q;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Do you want to buy it with " + x + "$");
        alert.setContentText(null);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MyData.shoppingcart.addOrder(new ORDEREDITEM(p, q));
            orders.appendText(String.format("%-20s %-4d %-3f$%n", p.getName(), q, x));
            total += x;
            totalTF.setText("" + total + "$");
        }

    }


    @FXML
    private void checkout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Total price " + total + "$ Thanks for visiting us ☻");
        alert.setContentText(null);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            MyData.shoppingcart.getOrdered_list().clear();
            mainController.unloadScreen(Store.MakeOrderID);
            mainController.loadScreen(Store.MakeOrderID, Store.MakeOrderFile);
            mainController.setScreen(Store.MenuID);
        }
        
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        mainController = screenPage;
    }

}
