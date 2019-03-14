package main.java.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class main extends Application {

    public static Stage primStage;

    @Override
    public  void start(Stage primaryStage) throws Exception{

//        for (int x = 0; x< getClass().getDeclaredMethods().length; x++){
//            System.out.println( getClass().getDeclaredMethods()[x].getName());
//        }
        System.out.println(getClass().getResource("main.fxml"));
        URL url = getClass().getResource("main.fxml");
        if (url == null) {
            System.out.println("No FXML file found, \"" + "main.fxml" + "\"");
            Platform.exit();
            return;
        }

        Parent root = FXMLLoader.load(url);
        primStage = primaryStage;
        primStage.setTitle("Game Launcher");
        primStage.setScene(new Scene(root, 600, 400));
        primStage.show();
        System.out.println();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
