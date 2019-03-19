package Reversi;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.util.Controller;
import main.java.util.Users;

import java.util.List;

public class ReversiController //implements Controller
{
    public void setPlayers(Users player1, Users player2){

    }


    @FXML
    private Button b0_0, b0_1, b0_2, b0_3, b0_4, b0_5, b0_6, b0_7,
            b1_0, b1_1, b1_2, b1_3, b1_4, b1_5, b1_6, b1_7,
            b2_0, b2_1, b2_2, b2_3, b2_4, b2_5, b2_6, b2_7,
            b3_0, b3_1, b3_2, b3_3, b3_4, b3_5, b3_6, b3_7,
            b4_0, b4_1, b4_2, b4_3, b4_4, b4_5, b4_6, b4_7,
            b5_0, b5_1, b5_2, b5_3, b5_4, b5_5, b5_6, b5_7,
            b6_0, b6_1, b6_2, b6_3, b6_4, b6_5, b6_6, b6_7,
            b7_0, b7_1, b7_2, b7_3, b7_4, b7_5, b7_6, b7_7;


    private Reversi game;
    private int turn = 0;



    public ReversiController()
    {
        game = new Reversi(8,8);
        //game.GaemeBoard.printBoard();


    }

    public String getTurn()
    {
        if(turn == 0)
        {
            return "B";
        }
        else
        {
            return "W";
        }

    }

    // GETS THE COORD OF CLICKED (DO STUFF)
    public void handleButtonClicked(Event event)
    {

        String ClickedButton = ((Control)event.getSource()).getId();
        ClickedButton = ClickedButton.replace("b", "");


        int ClickedRow =  Integer.parseInt(ClickedButton.split("_")[0]);
        int ClickedCol =  Integer.parseInt(ClickedButton.split("_")[1]);
        System.out.println(ClickedRow + "," + ClickedCol);


        // Check if slot is empty/available
        if (game.isCellAvailable(ClickedRow,ClickedCol))
        {
            //System.out.println("EMPTY");
            // check if move is valid
            // ************
            if (game.currentPlayerHasValidMove())
            {
                //System.out.println(game.getFlippedItems(ClickedRow,ClickedCol, getTurn()));
                if(game.getFlippedItems(ClickedRow,ClickedCol, getTurn()).size() > 0)
                {
                    handleMove((Button)event.getSource(), ClickedRow, ClickedCol);
                }


            }
        }







        // place piece
        //((Control) event.getSource()).setStyle("-fx-background-color: red");


    }


    void flipButton(String buttonName, String color)
    {
        if (buttonName.equals("b0_0"))
        {
            b0_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_1"))
        {
            b0_1.setStyle("-fx-background-color: " + color);

        }
        if (buttonName.equals("b0_2"))
        {
            b0_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_3"))
        {
            b0_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_4"))
        {
            b0_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_5"))
        {
            b0_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_6"))
        {
            b0_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b0_7"))
        {
            b0_7.setStyle("-fx-background-color: " + color);
        }



        if (buttonName.equals("b1_0"))
        {
            b1_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_1"))
        {
            b1_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_2"))
        {
            b1_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_3"))
        {
            b1_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_4"))
        {
            b1_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_5"))
        {
            b1_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_6"))
        {
            b1_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b1_7"))
        {
            b1_7.setStyle("-fx-background-color: " + color);
        }




        if (buttonName.equals("b2_0"))
        {
            b2_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_1"))
        {
            b2_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_2"))
        {
            b2_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_3"))
        {
            b2_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_4"))
        {
            b2_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_5"))
        {
            b2_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_6"))
        {
            b2_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b2_7"))
        {
            b2_7.setStyle("-fx-background-color: " + color);
        }


        if (buttonName.equals("b3_0"))
        {
            b3_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_1"))
        {
            b3_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_2"))
        {
            b3_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_3"))
        {
            b3_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_4"))
        {
            b3_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_5"))
        {
            b3_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_6"))
        {
            b3_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b3_7"))
        {
            b3_7.setStyle("-fx-background-color: " + color);
        }




        if (buttonName.equals("b4_0"))
        {
            b4_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_1"))
        {
            b4_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_2"))
        {
            b4_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_3"))
        {
            b4_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_4"))
        {
            b4_4.setStyle("-fx-background-color: " + color);

        }
        if (buttonName.equals("b4_5"))
        {
            b4_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_6"))
        {
            b4_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b4_7"))
        {
            b4_7.setStyle("-fx-background-color: " + color);
        }





        if (buttonName.equals("b5_0"))
        {
            b5_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_1"))
        {
            b5_1.setStyle("-fx-background-color: " + color);

        }
        if (buttonName.equals("b5_2"))
        {
            b5_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_3"))
        {
            b5_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_4"))
        {
            b5_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_5"))
        {
            b5_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_6"))
        {
            b5_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b5_7"))
        {
            b5_7.setStyle("-fx-background-color: " + color);
        }




        if (buttonName.equals("b6_0"))
        {
            b6_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_1"))
        {
            b6_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_2"))
        {
            b6_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_3"))
        {
            b6_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_4"))
        {
            b6_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_5"))
        {
            b6_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_6"))
        {
            b6_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b6_7"))
        {
            b6_7.setStyle("-fx-background-color: " + color);
        }


        if (buttonName.equals("b7_0"))
        {
            b7_0.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_1"))
        {
            b7_1.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_2"))
        {
            b7_2.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_3"))
        {
            b7_3.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_4"))
        {
            b7_4.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_5"))
        {
            b7_5.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_6"))
        {
            b7_6.setStyle("-fx-background-color: " + color);
        }
        if (buttonName.equals("b7_7"))
        {
            b7_7.setStyle("-fx-background-color: " + color);
        }

    }

    private void handleMove(Button source, int row, int col)
    {
        if (this.turn == 0) {
            source.setStyle("-fx-background-color: BLACK");

            for(List<Integer> flipCoord: game.getFlippedItems(row,col,getTurn()))
            {
                //System.out.println("b" + flipCoord.get(0) + "_" + flipCoord.get(1));
                flipButton("b" + flipCoord.get(0) + "_" + flipCoord.get(1), "BLACK");



            }
        } else if (this.turn == 1) {
            source.setStyle("-fx-background-color: WHITE");
            for(List<Integer> flipCoord: game.getFlippedItems(row,col,getTurn()))
            {
                //System.out.println("b" + flipCoord.get(0) + "_" + flipCoord.get(1));
                flipButton("b" + flipCoord.get(0) + "_" + flipCoord.get(1), "WHITE");



            }
        }
        game.makeMove(row,col);


        switchMove();


        // if current player doesnt have a move
        if ( !game.currentPlayerHasValidMove())
        {
            // switch moves
            switchMove();
            if (game.currentPlayerHasValidMove())
            {
                System.out.println("Switched: no possible moves for last player");
            }


            // if new player doesnt have move
            if ( !game.currentPlayerHasValidMove())
            {
                createEndGame();
                System.out.println("WINNER IS PLAYER: " + game.getWinner());
            }

        }



    }

    private void switchMove()
    {
        if (this.turn == 0) {
            this.turn = 1;
        } else if (this.turn == 1) {
            this.turn = 0;
        }

    }

    private void createEndGame() {
        final Stage dialog = new Stage();

        Button quitBtn = new Button();
        quitBtn.setText("Quit!");
        quitBtn.setOnAction((e) -> Platform.exit());


        dialog.initModality(Modality.APPLICATION_MODAL);
        //dialog.initOwner(main.main.primStage);
        dialog.setTitle("Game Over!");
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(winnerOrTie()));
        dialogVbox.getChildren().add(quitBtn);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private String winnerOrTie() {
        if (!game.getWinner().equals("")) {
            return "Winner!: " + game.getWinner();
        } else if (game.isGameOver()) {
            return "Game was a tie!";
        }
        return "";
    }
}
