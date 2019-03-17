package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane root;
    public Button btnCustomer;
    public Button btnItem;
    public Button btnOrder;
    public Button btnOrderDetails;

    public void navigateCustomer(ActionEvent actionEvent) throws IOException {

        Parent customerRoot= FXMLLoader.load(this.getClass().getResource("/view/CustomerForm.fxml"));
        Scene customerScene =new Scene(customerRoot);
        Stage primaryStage= (Stage) root.getScene().getWindow();
        primaryStage.setScene(customerScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Customer Form");

        //now when press navigatecustomer button ,window navigate to customer page from main form....


    }

    public void navigateItems(ActionEvent actionEvent) throws IOException {

        Parent customerRoot= FXMLLoader.load(this.getClass().getResource("/view/ItemForm.fxml"));
        Scene customerScene =new Scene(customerRoot);
        Stage primaryStage= (Stage) root.getScene().getWindow();
        primaryStage.setScene(customerScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Item Form");



    }

    public void navigateOrder(ActionEvent actionEvent) throws IOException {
        Parent customerRoot= FXMLLoader.load(this.getClass().getResource("/view/OrderForm.fxml"));
        Scene customerScene =new Scene(customerRoot);
        Stage primaryStage= (Stage) root.getScene().getWindow();
        primaryStage.setScene(customerScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Order Form");

    }

    public void navigateOrderDetails(ActionEvent actionEvent) throws IOException {
        Parent customerRoot= FXMLLoader.load(this.getClass().getResource("/view/OrderDetailsForm.fxml"));
        Scene customerScene =new Scene(customerRoot);
        Stage primaryStage= (Stage) root.getScene().getWindow();
        primaryStage.setScene(customerScene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Order Details Form");

    }
}
