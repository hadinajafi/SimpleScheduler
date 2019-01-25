/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxsimpleplanner;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author hadin
 */
public class JavaFXSimplePlanner extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //anchorPane is default layout
        AnchorPane root = null;
        try {
            //loading the fxml file.
            root = FXMLLoader.load(getClass().getResource("TabbedLayout.fxml"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Scene scene = new Scene(root);
        //loading the css file to the scene.
        scene.getStylesheets().add(getClass().getResource("tabbedlayout.css").toExternalForm());
        primaryStage.setTitle("Teyhu Simple Scheduler"); //title
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(460);
        primaryStage.setScene(scene);
        primaryStage.show();
        //adding kill the application on closing the main window. in some cases when multiple windows are open, closing the main window, casue the app stay open with other opened windows, but main window is parent.
        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
