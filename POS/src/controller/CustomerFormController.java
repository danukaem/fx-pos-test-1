package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerFormController {
    public AnchorPane root;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public TableView<Customer> tblCustomers;
    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnHome;

    ArrayList<Customer> customer = new ArrayList<>();

    ObservableList<Customer> customers = null;

    public void initialize() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerpos", "root", "1234");
        PreparedStatement scfc = connection.prepareStatement("select * from customer");


        ResultSet resultSet = scfc.executeQuery();

        while(resultSet.next()){
            String id= resultSet.getString(1);
            String name= resultSet.getString(2);
            String address= resultSet.getString(3);
            Customer c=new Customer(id,name,address);
            customer.add(c);
            tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));//this id should be EQUAL TO Customer class=> id
            tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

            customers= FXCollections.observableList(customer);
            tblCustomers.setItems(customers);




        }



    }


    public void saveCustomer(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerpos", "root", "1234");
        PreparedStatement scfc = connection.prepareStatement("insert into customer values (?,?,?)");

        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        scfc.setObject(1, id);
        scfc.setObject(2, name);
        scfc.setObject(3, address);

        int i = scfc.executeUpdate();
        if (i > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully Added", ButtonType.OK).show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Unsuccessful ", ButtonType.OK).show();

        }
    }

    public void updateCustomer(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerpos", "root", "1234");
        PreparedStatement scfc = connection.prepareStatement("update customer set name=?,address=? where id=?");

        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        scfc.setObject(1, name);
        scfc.setObject(2, address);
        scfc.setObject(3, id);

        int i = scfc.executeUpdate();
        if (i > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully updated", ButtonType.OK).show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Unsuccessful ", ButtonType.OK).show();

        }

    }

    public void deleteCustomer(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerpos", "root", "1234");
        PreparedStatement scfc = connection.prepareStatement("delete from customer where id=?");

        String id = txtID.getText();


        scfc.setObject(1, id);

        int i = scfc.executeUpdate();
        if (i > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successfully deleted", ButtonType.OK).show();

        } else {
            new Alert(Alert.AlertType.WARNING, "Unsuccessful ", ButtonType.OK).show();

        }

    }

    public void navigateHome(ActionEvent actionEvent) throws IOException {

        Parent customerRoot = FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"));
        Scene customerScene = new Scene(customerRoot);
        Stage primaryStage = (Stage) root.getScene().getWindow();
        primaryStage.setScene(customerScene);
        primaryStage.centerOnScreen();


    }
}
