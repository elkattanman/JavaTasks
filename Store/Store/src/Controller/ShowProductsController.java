/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import Model.Product;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import store.Store;

/**
 * FXML Controller class
 *
 * @author elkat
 */
public class ShowProductsController implements Initializable, ControlledScreen {

    private ProductDAO productDAO = new ProductDAO();
    ObservableList<Product> list;

    @FXML
    private TreeTableView<Product> table;
    @FXML
    private TreeTableColumn<Product, String> idCol;
    @FXML
    private TreeTableColumn<Product, String> nameCol;
    @FXML
    private TreeTableColumn<Product, String> priceCol;
    private ScreensController mainController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        idCol.setCellValueFactory(new TreeTableColumn<>("id"));
//        nameCol.setCellValueFactory(new TreeTableColumn<>("name"));
//        priceCol.setCellValueFactory(new TreeTableColumn<>("price"));
        idCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Product, String> param) -> param.getValue().getValue().id);
        nameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Product, String> param) -> param.getValue().getValue().name);
        priceCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Product, String> param) -> param.getValue().getValue().price);
        try {
            list = FXCollections.observableArrayList(productDAO.getAll());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
        TreeItem<Product> root = new RecursiveTreeItem<>(list, RecursiveTreeObject::getChildren);
        table.setRoot(root);
        table.setShowRoot(false);
    }

    @FXML
    private void back(ActionEvent event) {
        mainController.setScreen(Store.MenuID);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        mainController = screenPage;
    }

}
