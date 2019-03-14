package main.java.TicTacToe;
import main.java.main.*;

import main.java.util.*;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TicTacToeController {
    private TicTacToe game;
    Users player1;
    Users player2;
    private int turn = 0;
    public Button b1, b2, b3, b4, b5, b6, b7, b8, b9;


    public TicTacToeController() {
        // Initialize Players
        game = new TicTacToe();

    }

    public void setPlayers(Users player1,Users player2){
        this.player1 = player1;
        this.player2 = player2;
        game.setStages(player1, player2);
        game.setFirstStage("0", player1);
    }

    public void handleButtonClicked(Event event) {
        Button source = (Button) event.getSource();
        if (source.equals(b1)) {
            handleMove(source,0,0);
        }
        if (source.equals(b2)) {
            handleMove(source,0,1);

        }
        if (source.equals(b3)) {
            handleMove(source,0,2);

        }
        if (source.equals(b4)) {
            handleMove(source,1,0);

        }
        if (source.equals(b5)) {
            handleMove(source,1,1);

        }
        if (source.equals(b6)) {
            handleMove(source,1,2);

        }
        if (source.equals(b7)) {
            handleMove(source,2,0);

        }
        if (source.equals(b8)) {
            handleMove(source,2,1);

        }
        if (source.equals(b9)) {
            handleMove(source,2,2);
        }
        if (!game.getWinner().equals("") || game.isGameOver()) {
            this.createEndGame();
        }

    }

    private void handleMove(Button source, int row, int col){
        if (game.isValid(row, col)) {
            game.makeMove(row, col, game.getCurrentTurn());
            handleMove(source);
            switchMove();
        }
    }

    private void handleMove(Button button) {
        if (this.turn == 0) {
            button.setStyle("-fx-text-fill: red");
            button.setText("0");
        } else if (this.turn == 1) {
            button.setStyle("-fx-text-fill: blue");
            button.setText("X");
        }
    }

    private void switchMove() {
        if (this.turn == 0) {
            this.turn = 1;
        } else if (this.turn == 1) {
            this.turn = 0;
        }
    }

    public void handleActionQuit() {
        Platform.exit();
    }

    private void createEndGame() {
        final Stage dialog = new Stage();

        Button quitBtn = new Button();
        quitBtn.setText("Quit!");
        quitBtn.setOnAction((e) -> Platform.exit());


        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(main.primStage);
        dialog.setTitle("Game Over!");
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(winnerOrTie()));
        dialogVbox.getChildren().add(quitBtn);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

//    private void createStartGame(){
//        final Stage dialog = new Stage();
//
//        TextField textField = new TextField();
//
//        dialog.initModality(Modality.APPLICATION_MODAL);
//        dialog.initOwner(Main.primStage);
//        dialog.setTitle("Game Settings");
//        VBox dialogVbox = new VBox(20);
//        dialogVbox.getChildren().add(new Text(winnerOrTie()));
//        dialogVbox.getChildren().add(textField);
//        Scene dialogScene = new Scene(dialogVbox, 300, 200);
//        dialog.setScene(dialogScene);
//        dialog.show();
//    }

    private String winnerOrTie() {
        if (!game.getWinner().equals("")) {
            return "Winner!: " + game.getWinner();
        } else if (game.isGameOver()) {
            return "Game was a tie!";
        }
        return "";
    }

}
