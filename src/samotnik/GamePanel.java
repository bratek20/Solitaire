/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author BRudzki
 */
public class GamePanel extends JPanel {
    private GameBoard gameBoard;
    private BoardCell selectedCell, highlightedCell;
    private int selectedI, selectedJ;
    private GameLabel info;
    private KeyboardListener keyboard;
    private boolean britishMode = true;
    
    public static Color backgroundColor = Color.DARK_GRAY;
    
    public GamePanel(GameLabel info){
        this.info = info;
        
        keyboard = new KeyboardListener(this);
        addKeyListener(keyboard);
    }
    
    public void select(BoardCell cell){
        requestFocus();
        
        selectedCell = cell;
        if(cell != null){
            selectedI = cell.getI();
            selectedJ = cell.getJ();
        }
        repaint();
    }
    
    public void highlight(BoardCell cell){
        highlightedCell = cell;
        repaint();
    }
    
    public BoardCell getSelectedCell(){
        return selectedCell;
    }
    
    public BoardCell getHighlightedCell(){
        return highlightedCell;
    }
    
    public BoardCell[][] getBoard(){
        return gameBoard.getBoard();
    }
    
    private boolean beatable(int i,int j){
        if(Math.abs(i-selectedI)==2 && j==selectedJ) return true;
        if(Math.abs(j-selectedJ)==2 && i==selectedI) return true;
        return false;
    }
    
    public void beat(int i,int j){
        requestFocus();
        
        if(selectedCell == null)return;
        
        if(beatable(i,j)){
            int beatI=i-(i-selectedI)/2, beatJ = j-(j-selectedJ)/2;
 
            BoardCell beatCell = gameBoard.getBoard()[beatI][beatJ];
            BoardCell emptyCell = gameBoard.getBoard()[i][j];
            
            if(beatCell.hasPawn()){
                beatCell.deletePawn();
                selectedCell.deletePawn();
                emptyCell.addPawn();
                
                info.showCurrentState(gameBoard.getBoard());
                selectedCell = null;
                repaint();
            }
        }
    }
    
    public void startNewGame(){
        requestFocus();
        
        if(britishMode) gameBoard = new BritishBoard(this);
        else gameBoard = new EuropeanBoard(this);
        
        info.startGame();
        
        repaint();
    }
    public void endGame(){
        gameBoard = null;
        
        info.endGame();
        
        repaint();
    }
    public void setGameMode(boolean britishMode){
        this.britishMode = britishMode;
    }
    
    public boolean isPlaying(){
        return gameBoard != null && !info.isGameEnded();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        if(gameBoard != null) gameBoard.paint(g);
    }
}
