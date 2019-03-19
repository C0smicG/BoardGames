package util;


import javafx.event.Event;

public interface Controller {
    void setPlayers(Users player1, Users player2);


    void  handleButtonClicked(Event event);

}