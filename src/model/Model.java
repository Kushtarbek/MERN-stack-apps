package model;

import javax.swing.text.View;

public class Model {
    private View v;
    private int playerId;
    private int movesCount;
    private char [][] board;
    private String message;

    public Model(){
        this.board = new char[3][3];
        this.movesCount = 9;
        this.playerId = 1;
    }

    public void registerView(View v){
        this.v = v;
    }

    public int getPlayerId(){
        return playerId;
    }

    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }

    public int getMovesCount(){
        return movesCount;
    }

    public void setMovesCount(int movesCount){
        this.movesCount = movesCount;
    }

    public char [][] getBoard(){
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void PlayMove( int x, int y){

        if(getMovesCount() > 0){
            if(playerId%2 != 0){
                board[x][y] = 'X';
            }else{
                board[x][y] = '0';
            }

            setMovesCount(--movesCount);

            if(isWinner(x, y)){
                setMessage("Player "+ playerId + "is Winner!");
                v.isWinner(x, y, board[x][y], getMessage());

            }else if(getMovesCount() == 0){
                setMessage("No Winner! Game ended in Tie");
                v.isWinner(x, y, board[x][y], getMessage());

            }else{
                if(playerId%2 != 0){
                    setPlayerId(2);
                    setMessage(" '0': Player "+getPlayerId());

                }else{
                    setPlayerId(1);
                    setMessage(" 'X': Player "+getPlayerId());
                }

                v.update(x, y, board[x][y], getMessage());
            }
        }
    }

    public boolean isWinner(int x, int y){
        return false;
    }
}