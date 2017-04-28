/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author BRudzki
 */
public class GameLabel extends JLabel{
    private boolean gameEnded = true;
    public GameLabel(){
        setText("Welcome!");
        
        setForeground(Color.RED);
        
        setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void startGame(){
        gameEnded = false;
        setText("Game started!");
    }
    
    public void endGame(){
        gameEnded = true;
        setText("Game ended.");
    }
    
    public boolean isGameEnded(){
        return gameEnded;
    }
    
    public void showCurrentState(BoardCell[][] board){
        int pawns=0;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                if(board[i][j] != null && board[i][j].hasPawn())
                    pawns++;
    
        gameEnded=true;
        if(noPossibleMove(board))
            setText("You have no possible move. You lost! I'm so sorry :(");
        else if(pawns==0)
            setText("Something is bad, like super bad. Seriously.");
        else if(pawns==1)
            setText("Congratulation! You have won!");
        else{
            setText("You have to beat "+(pawns-1)+" pawns to win the game.");
            gameEnded = false;
        }
    }
    
    private boolean canBeat(BoardCell[][] board, int i1, int j1, int i2, int j2){
        if(board[i1][j1]==null || board[i2][j2]==null)return false;
        if(!board[(i1+i2)/2][(j1+j2)/2].hasPawn())return false;
        if(board[i1][j1].hasPawn() == board[i2][j2].hasPawn())return false;
        
        return true;
    }
    private boolean noPossibleMove(BoardCell[][] board){
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++){
                if(i+2<board.length && canBeat(board, i,j,i+2,j))
                    return false;
                if(j+2<board[i].length && canBeat(board, i,j,i,j+2))
                    return false;
            }
        return true;
    }
}
