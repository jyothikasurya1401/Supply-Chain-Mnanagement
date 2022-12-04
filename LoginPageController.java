package com.example.supplychain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.*;

public class LoginPageController {
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    public void login(MouseEvent event)throws SQLException, IOException {
       /* System.out.println(email.getText());
        System.out.println(password.getText());*/
        String query=String.format("Select * from user where emailId='%s' AND pass='%s'",email.getText(),password.getText());
        ResultSet res=HelloApplication.connection.executeQuery(query);

        if(res.next()){
        String userType=res.getString("userType");
        HelloApplication.emailId=res.getString("emailId");
        if(userType.equals("Buyer")){
            System.out.println("Logged in as Buyer!");


            ProductPage products=new ProductPage();
            Header header=new Header();

            ListView<HBox>productList=products.showProducts();

            AnchorPane productPane=new AnchorPane();
            productPane.setLayoutX(50);
            productPane.setLayoutY(100);
            productPane.getChildren().add(productList);


            HelloApplication.root.getChildren().clear();
            HelloApplication.root.getChildren().addAll(header.root,productPane);


        }
        else{
            AnchorPane SellerPage= FXMLLoader.load((Objects.requireNonNull(getClass().getResource("SellerPage.fxml"))));
            HelloApplication.root.getChildren().add(SellerPage);
            System.out.println("Logged in as Seller!");
        }

        }
        else{
            Dialog<String> dialog=new Dialog<>();
            dialog.setTitle("Login");
            ButtonType type=new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Login Failed Please Try again!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }

        }


    }


