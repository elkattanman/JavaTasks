/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import Model.Customer;
import Model.Person;
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
public class ShowCustomerController implements Initializable, ControlledScreen {

    private CustomerDAO customerDOA =new CustomerDAO();
    ObservableList<Person> list;

    private ScreensController mainController;
    @FXML
    private TreeTableView<Person> table;
    @FXML
    private TreeTableColumn<Person, String> nameCol;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TreeTableColumn<Person, String> emailCol;
    @FXML
    private TreeTableColumn<Person, String> addressCol;
    @FXML
    private TreeTableColumn<Person, String> phoneCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, String> param) -> param.getValue().getValue().name);
        emailCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, String> param) -> param.getValue().getValue().email);
        addressCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, String> param) -> param.getValue().getValue().address);
        phoneCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<Person, String> param) -> param.getValue().getValue().phone);

        try {
            list = FXCollections.observableArrayList(customerDOA.getAll());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.err.println(ex);
        }
        TreeItem<Person> root = new RecursiveTreeItem<>(list, RecursiveTreeObject::getChildren);
        table.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends TreeItem<Person>> observable, TreeItem<Person> oldValue, TreeItem<Person> newValue) -> {
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
    private void update(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        Person p = new Person(nameTF.getText(), addressTF.getText(), phoneTF.getText(), emailTF.getText());
        nameTF.clear();        emailTF.clear();        addressTF.clear();        phoneTF.clear();
        try {
            customerDOA.update((Customer) p);
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
        Person p = new Person(nameTF.getText(), addressTF.getText(), phoneTF.getText(), emailTF.getText());
        nameTF.clear();
        nameTF.clear();        emailTF.clear();        addressTF.clear();        phoneTF.clear();
        try {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Do you want to delete!");
            alert.setContentText(null);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                customerDOA.delete((Customer) p);
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

    private void showDetails(TreeItem<Person> newValue) {
        nameTF.setText(newValue.getValue().getName());
        emailTF.setText(newValue.getValue().getEmail());
        phoneTF.setText(newValue.getValue().getPhone());
        addressTF.setText(newValue.getValue().getAddress());
    }


}
