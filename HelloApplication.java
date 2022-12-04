package com.example.supplychain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    public static  DatabaseConnection connection;

    public static Group root;
    public static String emailId;

    @Override
    public void start(Stage stage) throws SQLException,IOException {
       connection=new DatabaseConnection();
       emailId="";
        root=new Group();
        Header header=new Header();
        ProductPage products=new ProductPage();
        ListView<HBox> productList=products.showProducts();
        AnchorPane productPane=new AnchorPane();
        productPane.setLayoutX(50);
        productPane.setLayoutY(100);
        productPane.getChildren().add(productList);
        root.getChildren().addAll(header.root,productPane);
       /* ResultSet res=connection.executeQuery("select * from product");
        while(res.next()){
            System.out.println(res.getString("productName"));

        }
        int res2= connection.executeUpdate("insert into product values(3,'laptop',23450,'deexika@gmail.com')");
        if(res2>0){
            System.out.println("a new row is inserted");
        }*/

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Supplychain");
        stage.setScene(new Scene(root,500,500));
        stage.show();

            stage.setOnCloseRequest(e -> {
            try {
                connection.con.close();
                System.out.println("Connection is closed");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}