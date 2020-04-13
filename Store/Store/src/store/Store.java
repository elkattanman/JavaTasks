package store;

import Controller.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Store extends Application {
    public static String MenuID = "menu";
    public static String LoginID = "login";
    public static String LoginAdminID = "loginAdmin";
    public static String RegisterID = "register";
    public static String ShowProductID = "showProduct";
    public static String ShowCustomerID = "showCustomer";
    public static String ShowProductAdminID = "showAdminProduct";
    public static String MakeOrderID = "makeOrder";
    public static String MenuAdminID="menuAdmin";
    public static String MenuFile = "/View/Menu.fxml";
    public static String LoginFile = "/View/Login.fxml";
    public static String LoginAdminFile = "/View/LoginAdmin.fxml";
    public static String RegisterFile = "/View/Register.fxml";
    public static String ShowProductFile = "/View/ShowProducts.fxml";
    public static String ShowCustomerFile = "/View/ShowCustomer.fxml";
    public static String ShowProductAdminFile = "/View/ShowProductsAdmin.fxml";
    public static String MakeOrderFile = "/View/MakeOrder.fxml";
    public static String MenuAdminFile = "/View/MenuAdmin.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(LoginID, LoginFile);
        mainContainer.loadScreen(LoginAdminID, LoginAdminFile);
        mainContainer.loadScreen(RegisterID, RegisterFile);
        mainContainer.loadScreen(ShowProductID, ShowProductFile);
        mainContainer.loadScreen(ShowCustomerID, ShowCustomerFile);
        mainContainer.loadScreen(ShowProductAdminID, ShowProductAdminFile);
        mainContainer.loadScreen(MenuID, MenuFile);
        mainContainer.loadScreen(MenuAdminID, MenuAdminFile);
        mainContainer.loadScreen(MakeOrderID, MakeOrderFile);
        mainContainer.setScreen(LoginID);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Welcome");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
