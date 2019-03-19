package Memory;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class MemoryController
{
    @FXML
    private GridPane grid;
    @FXML
    private Label p1Score;
    @FXML
    private Label p2Score;
    @FXML
    private Label p1Label;
    @FXML
    private Label p2Label;

    private Memory game;
    private int dimension = 2;
    private ArrayList<Label> move = new ArrayList<>();

    public void startGame()
    {
        game = new Memory(dimension);
        fillBoard();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(4), e ->
                {
                    hideBoard();
                })
        );
        timeline.play();
    }

    public void endGame()
    {
        resetBoard();
        p1Score.setText("0");
        p2Score.setText("0");
    }

    public void decreaseDifficulty()
    {
        if(dimension >= 4 )
        {
            dimension -= 2;
            updateBoard(dimension);
        }
    }

    public void increaseDifficulty()
    {
        if(dimension <= 6)
        {
            dimension += 2;
            updateBoard(dimension);
        }
    }

    @FXML
    public void updateBoard(int dimension)
    {
        //clear board
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();

        //redraw
        for(int i = 0; i < dimension; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth((1/(double)dimension)*100);
            grid.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight((1/(double)dimension)*100);
            grid.getRowConstraints().add(row);
        }
    }

    public void fillBoard()
    {
        for(int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                Label label = new Label(game.lookup(i, j));
                label.setOpacity(1.0);
                label.setPrefWidth(grid.getWidth() / dimension);
                label.setPrefHeight(grid.getHeight() / dimension);
                label.setAlignment(Pos.CENTER);
                grid.add(label, i, j);

                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent e)
                    {
                        switch (move.size())
                        {
                            case 0: //first move
                                label.setOpacity(1.0);
                                move.add(label);
                                break;
                            case 1: // second move
                                label.setOpacity(1.0);
                                move.add(label);
                                if (move.get(0).getText().equals(move.get(1).getText()))
                                {
                                    disableTiles();
                                    System.out.println("Match!");
                                    updateScore();
                                    move.clear(); // copy code cringe
                                    nextTurn();
                                }
                                else
                                {

                                    Timeline timeline = new Timeline(
                                            new KeyFrame(Duration.seconds(1), f ->
                                            {
                                                hideTiles();
                                                move.clear();
                                                nextTurn();
                                            })
                                    );
                                    timeline.play();
                                    System.out.println("No match!");
                                    break;
                                }
                        }
                    }
                };
                label.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }
        }
    }

    public void hideTiles()
    {
        for(Label tile: move)
        {
            tile.setOpacity(0.0);
        }
    }

    public void showBoard()
    {
        for(int i = 1; i <= dimension*dimension; i++)
        {
            grid.getChildren().get(i).setOpacity(1.0);
        }
    }

    public void hideBoard()
    {
        for(int i = 1; i <= dimension*dimension; i++)
        {
            Label label = (Label)grid.getChildren().get(i);
            if(!(label.isDisabled()))
            label.setOpacity(0.0);
        }
    }

    public void resetBoard()
    {
        grid.getChildren().remove(1, dimension*dimension+1);
        p1Label.setUnderline(true);
        p2Label.setUnderline(false);
    }

    public void disableTiles()
    {
        for(Label tile: move)
        {
            tile.setDisable(true);
        }
    }

    public void updateScore()
    {
        game.updateScore();
        int[] score = game.getScoreboard();
        p1Score.setText((Integer.toString(score[0])));
        p2Score.setText((Integer.toString(score[1])));
    }

    public void nextTurn()
    {
        if(game.IsGameOver())
        {
            System.out.println("Game Over!");
        }
        game.changePlayer();
        if(p1Label.isUnderline())
        {
            p1Label.setUnderline(false);
            p2Label.setUnderline(true);
        }
        else
        {
            p2Label.setUnderline(false);
            p1Label.setUnderline(true);
        }
    }
}
