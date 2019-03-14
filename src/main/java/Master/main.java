package Master;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class main extends Application {

    public static Stage primStage;

    @Override
    public  void start(Stage primaryStage) throws Exception{

        URL url = getClass().getResource("/view/Master.fxml");
        if (url == null) {
            System.out.println("No FXML file found, \"" + "Master.fxml" + "\"");
            Platform.exit();
            return;
        }

        Parent root = FXMLLoader.load(url);
        primStage = primaryStage;
        primStage.setTitle("Game Launcher");
        primStage.setScene(new Scene(root, 600, 550));
        primStage.show();
        System.out.println();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
