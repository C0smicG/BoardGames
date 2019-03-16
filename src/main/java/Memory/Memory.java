package Memory;
import java.util.ArrayList;
import java.util.Random;

public class Memory //implements GameLogic
{
    private Board board;
    Users[] players;
    int currentTurn;
    private int [] scoreboard;
    int dimension;

    Memory(int dim) // dim should be even by the way
    {
        board = new Board(dim, dim);
        fillBoard();
        scoreboard = new int[]{0,0};
        currentTurn = 0;
        dimension = dim;
    }

    public void makeMove (int x, int y)
    {
    // not exactly sure what this does yet
    }

    public boolean isValid()
    {
        return false;
    }

    public void changePlayer()
    {
        if(currentTurn == 0)
            currentTurn = 1;
        else
            currentTurn = 0;
    }

    public Users getCurrentPlayer()
    {
        return players[currentTurn];
    }
    public boolean IsGameOver()
    {
        return((scoreboard[0] + scoreboard[1]) == dimension * dimension / 2);
    }

    //getWinner()
    public Board getBoard()
    {
        return board;
    }

    public void fillBoard() { //fills board with random pairs of numbers
        ArrayList<Integer> elements = new ArrayList<Integer>();
        Random rand = new Random();

        //adds pairs to elements
        for (int i = 1; i <= ((board.getCols() * board.getRows()) / 2); i++) {
            elements.add(i);
            elements.add(i);
        }

        for(int i = 0; i < board.getRows(); i++)
        {
            for(int j = 0; j < board.getCols(); j++)
            {
                int randIndex = rand.nextInt(elements.size()); //get random index
                String data = elements.get(randIndex).toString(); //retrieve data
                elements.remove(randIndex); // remove element so it is not chosen again
                board.updateBoard(i, j, data);
            }
        }
    }

    public void updateScore()
    {
        scoreboard[currentTurn] += 1;
    }

    public int[] getScoreboard()
    {
        return scoreboard;
    }

    String lookup(int row, int col)
    {
        return board.getBoard().get(row).get(col); //this is really ugly
    }
}
