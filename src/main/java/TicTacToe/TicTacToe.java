package TicTacToe;

import models.Board;
import models.Users;

public class TicTacToe {
    Users currentTurn,player1,player2;
    private String currentStage = "";
    private int emptyCells = 9;
    private String O_stage = "";
    private String X_stage = "";
    private String winner = "";
    private String firstStage = "";
    Board board;

    public TicTacToe(){
        board = new Board(3,3);
    }


    public String getCurrentSymbol(){
        if(this.currentStage.equals(O_stage)) {
            return "0";
        }
        else if(this.currentStage.equals(X_stage)){
            return "X";
        }
        return "'";
    }

    public void setStages(Users player1, Users player2){
        O_stage = player1.getName();
//        player1.setSymbol("0");
        this.player1 = player1;


        X_stage = player2.getName();
//        player2.setSymbol("X");
        this.player2 = player2;

    }


    public void setFirstStage(String stage, Users user){
        if(stage == "O") {
            firstStage = O_stage;
            currentStage = O_stage;
        }
        else {
            firstStage = X_stage;
            currentStage = X_stage;
        }
        currentTurn = user;
    }

    private void changeplayer(){
        if(currentStage == O_stage){
            currentStage = X_stage;
        }
        else
            currentStage = O_stage;
        if(currentTurn.equals(this.player1)){
            this.currentTurn = this.player2;
        }
        else{
            this.currentTurn = this.player1;
        }
    }

    public String getCurrentStage(){
        return currentStage;
    }

    public Users getCurrentTurn(){
        return this.currentTurn;
    }


    public boolean isValid(int rowIndex, int columnIndex){

        if(outOfBoundary(rowIndex, columnIndex)){
            System.out.println("INVALID");
            return false;
        }

        if(cellIsEmpty(rowIndex, columnIndex))
            return true;
        else{
            System.out.println("INVALID");
            return false;

        }
    }

    private boolean outOfBoundary(int rowIndex, int columnIndex){
        return rowIndex < 0 || rowIndex > 2 || columnIndex < 0 || columnIndex > 2;
    }


    private boolean cellIsEmpty(int index1, int index2){
        return board.getBoard().get(index1).get(index2) == "'";
    }

    public void makeMove(int rowIndex, int columnIndex, Users player){
        if(!isValid(rowIndex, columnIndex)){
            return;
        }
        board.getBoard().get(rowIndex).set(columnIndex,player.getName());
        emptyCells --;
        checkWinner(player.getName());
        if(!winner.equals("")){
            return;
        }
        changeplayer();
    }

    private void checkWinner(String playername){
        if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(1).get(0).equals(playername) && board.getBoard().get(2).get(0).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(1).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(2).get(1).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(2).equals(playername) && board.getBoard().get(1).get(2).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(0).get(1).equals(playername) && board.getBoard().get(0).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(1).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(1).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(2).get(0).equals(playername) && board.getBoard().get(2).get(1).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(0).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(2).get(2).equals(playername)){
            winner = playername;}
        else if(board.getBoard().get(2).get(0).equals(playername) && board.getBoard().get(1).get(1).equals(playername) && board.getBoard().get(0).get(2).equals(playername)){
            winner = playername;}
        else if(emptyCells == 0)
            winner = "draw";
    }

    public boolean isGameOver() {
        return emptyCells == 0;
    }

    public String getWinner(){
        return winner;
    }


    public void setCurrentStage(String Cur){
        currentStage = Cur;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }


}
