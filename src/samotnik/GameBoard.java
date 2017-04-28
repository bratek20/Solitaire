/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BRudzki
 */
abstract public class GameBoard {
    public final static int SIZE=7;
    public static Color tableColor = new Color(50,33,4);
   
    protected BoardCell board[][];
    protected GamePanel parent;
    public GameBoard(GamePanel parent){
        this.parent = parent;
        board = new BoardCell[SIZE][SIZE];
        fillBoard();
        
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                if(board[i][j]!=null)
                    parent.add(board[i][j]);
    }
    
    abstract protected void fillBoard();
    
    public BoardCell[][] getBoard(){
        return board;
    }
    
    public void paint(Graphics g){
        int w = parent.getWidth();
        int h = parent.getHeight();
        
        int cellSize = Math.min(w,h)/SIZE;
        int boardSize = cellSize*SIZE;
        
        int x = (w-boardSize)/2;
        int y = (h-boardSize)/2;
        
        g.setColor(tableColor);
        int d = boardSize/10;
        g.fillOval(x-d/2, y-d/2, boardSize+d, boardSize+d);
        
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                if(board[i][j]!=null)
                    board[i][j].paint(g, x+j*cellSize, y+i*cellSize, cellSize);
    }
}
