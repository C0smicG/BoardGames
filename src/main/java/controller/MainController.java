package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private ToggleGroup toggleGroup ;

    public void handlePlayClicked(){
        String gameName = ((RadioButton)toggleGroup.getSelectedToggle()).getText();
        String gameToOpen = ((RadioButton)toggleGroup.getSelectedToggle()).getId();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/"+gameToOpen));
            Parent gameFXML = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(gameName);
            stage.setScene(new Scene(gameFXML));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
