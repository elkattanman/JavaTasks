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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import store.Store;

/**
 * FXML Controller class
 *
 * @author elkat
 */
public class ShowProductsAdminController implements Initializable, ControlledScreen {

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
    @FXML
    private TextField idTF;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField priceTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        table.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends TreeItem<Product>> observable, TreeItem<Product> oldValue, TreeItem<Product> newValue) -> {
            showDetails(newValue);
        });
        table.setRoot(root);
        table.setShowRoot(false);
    }

    @FXML
    private void back(ActionEvent event) {
        mainController.unloadScreen(Store.ShowProductAdminID);
        mainController.loadScreen(Store.ShowProductAdminID, Store.ShowProductAdminFile);
        mainController.setScreen(Store.MenuAdminID);
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        mainController = screenPage;
    }

    @FXML
    private void add(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Product p = new Product(idTF.getText(), nameTF.getText(), "", priceTF.getText());
        idTF.clear();
        nameTF.clear();
        priceTF.clear();
        try {
            productDAO.insert(p);
            list.add(p);
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Insertion Complete");
            alert.setContentText(null);
            alert.show();
        } catch (Exception ex) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
    }

    @FXML
    private void update(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Product p = new Product(idTF.getText(), nameTF.getText(), "", priceTF.getText());
        idTF.clear();
        nameTF.clear();
        priceTF.clear();
        try {
            productDAO.update(p);
            ref();
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Update Complete");
            alert.setContentText(null);
            alert.show();
        } catch (Exception ex) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Product p = new Product(idTF.getText(), nameTF.getText(), "", priceTF.getText());
        idTF.clear();
        nameTF.clear();
        priceTF.clear();
        try {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Do you want to delete!");
            alert.setContentText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                productDAO.delete(p);
                ref();
                alert.setHeaderText("delete Complete!");
                alert.show();
            }

        } catch (Exception ex) {
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
    }

    void ref() {
        mainController.unloadScreen(Store.ShowProductAdminID);
        mainController.loadScreen(Store.ShowProductAdminID, Store.ShowProductAdminFile);
        mainController.setScreen(Store.ShowProductAdminID);
    }

    private void showDetails(TreeItem<Product> newValue) {
        idTF.setText(newValue.getValue().getId());
        nameTF.setText(newValue.getValue().getName());
        priceTF.setText(newValue.getValue().getPrice());
    }

}
