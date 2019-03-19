package Master;

import util.Users;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import TicTacToe.TicTacToeController;
import Reversi.ReversiController;
import Memory.MemoryController;
import Checkers.CheckersController;

import java.util.ArrayList;
import java.util.HashMap;

public class MainController {
    @FXML
    private ToggleGroup toggleGroup ;
    @FXML
    private TextField playerone;
    @FXML
    private TextField playertwo;

    public HashMap<String,Users> database = new HashMap<>();
    public ArrayList<Users> currentPlayers = new ArrayList<>();
//    public MainController(){
//        Gameplugins();
//    }
//
//    public void Gameplugins(){
//        File folder = new File(System.getProperty("user.dir") + "/src/main/java");
//        File[] listOfFiles = folder.listFiles();
//        for (int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isDirectory() && listOfFiles[i].getName() == "util") {
//                System.out.println("Directory " + listOfFiles[i].getName());
//            }
//            else if (listOfFiles[i].isDirectory() && listOfFiles[i].getName() == "Master"){
//                System.out.println("Directory " + listOfFiles[i].getName());
//            }
//        }
//    }
    public void handlePlayClicked(){
        String gameName = ((RadioButton)toggleGroup.getSelectedToggle()).getText();
        String gameToOpen = ((RadioButton)toggleGroup.getSelectedToggle()).getId();
        System.out.println(playerone.getText());
        if (!database.containsKey(playerone.getText())){
            currentPlayers.add(new Users(playerone.getText()));
        }else{
            currentPlayers.add(database.get(playerone.getText()));
        }

        if (!database.containsKey(playertwo.getText())){
            currentPlayers.add(new Users(playertwo.getText()));
        }else{
            currentPlayers.add(database.get(playertwo.getText()));
        }


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/"+gameToOpen));
            Parent gameFXML = fxmlLoader.load();



            if(gameName.equals("TicTacToe")){
                TicTacToeController controller = fxmlLoader.getController();
                controller.setPlayers(currentPlayers.get(0),currentPlayers.get(1));

            }

            if(gameName.equals("Reversi")){
                ReversiController controller = fxmlLoader.getController();
                controller.setPlayers(currentPlayers.get(0),currentPlayers.get(1));

            }

//            if(gameName.equals("Checkers")){
//                CheckersController controller = fxmlLoader.getController();
//                controller.setPlayers(currentPlayers.get(0),currentPlayers.get(1));
//
//            }
//
//            if(gameName.equals("Memory")){
//                MemoryController controller = fxmlLoader.getController();
//                controller.setPlayers(currentPlayers.get(0),currentPlayers.get(1));
//
//            }



            Stage stage = new Stage();
            stage.setTitle(gameName);
            stage.setScene(new Scene(gameFXML));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

