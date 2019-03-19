package util;

public interface GameLogic
{

    void makeMove (int x, int y);

    boolean isValid();

    void changePlayer();

    boolean IsGameOver();

    //getWinner()
    //getBoard()

}
