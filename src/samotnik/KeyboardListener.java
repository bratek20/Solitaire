/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javafx.beans.binding.Bindings;

/**
 *
 * @author BRudzki
 */
public class KeyboardListener extends KeyAdapter{
    private GamePanel panel;
    public KeyboardListener(GamePanel panel){
        this.panel = panel;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(!panel.isPlaying())return;
        
        if(e.getKeyCode()== KeyEvent.VK_LEFT)
            moveHighlightedCell(0,-1);
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            moveHighlightedCell(0,1);
        if(e.getKeyCode()== KeyEvent.VK_UP)
            moveHighlightedCell(-1,0);
        if(e.getKeyCode()== KeyEvent.VK_DOWN)
            moveHighlightedCell(1,0); 
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            BoardCell cell = panel.getHighlightedCell();
            if(cell == null){
                highlightCellWithPawn();
            }
            else{
                if(cell.hasPawn())
                    panel.select(cell);
                else
                    panel.beat(cell.getI(), cell.getJ());
            }
        }
    }
    
    private void highlightCellWithPawn(){
        if(panel.getSelectedCell() != null){
            panel.highlight(panel.getSelectedCell());
            panel.select(null);
            return;
        }
        
        BoardCell[][] board = panel.getBoard();      
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                if(board[i][j]!=null && board[i][j].hasPawn()){
                    panel.highlight(board[i][j]);
                    panel.select(null);
                    return;
                }
    }
    
    private void moveHighlightedCell(int di, int dj){
        BoardCell[][] board = panel.getBoard();
        BoardCell cell = panel.getHighlightedCell();
        
        if(cell == null){
            highlightCellWithPawn();
            return;
        }
        
        int i=cell.getI()+di, j=cell.getJ()+dj;
        
        if(i>=0 && i<board.length && j>=0 && 
           j<board[i].length && board[i][j]!=null)
            panel.highlight(board[i][j]);
    }
}
