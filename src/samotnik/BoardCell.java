/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author BRudzki
 */
public class BoardCell extends JComponent{
    public static Color pawnColor = Color.BLACK;
    public static Color boardColor = new Color(102, 51, 0);
    private Color selectionColor = Color.WHITE;
    private Color highlightedColor = Color.YELLOW;
    
    
    private final float pawnScale = 0.75f;
    
    private boolean busy = true;
    private int i,j;
    private GamePanel parent;
    private ContextMove contextMove;
    public BoardCell(GamePanel parent, int i, int j){
        this.parent = parent;
        this.i = i; this.j =j;
        
        contextMove = new ContextMove(parent, this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    if(busy){
                        parent.select(BoardCell.this);
                        parent.highlight(null);
                    }else
                        parent.beat(i,j);
                } 
                if(SwingUtilities.isRightMouseButton(e)){
                    contextMove.prepare();
                    contextMove.show(parent, getX()+getWidth()/2, getY()+getHeight()/2);
                }             
            }
        });
    }
    
    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }
    public void addPawn(){
        busy = true;
    }
    public void deletePawn(){
        busy = false;
    }
    public boolean hasPawn(){
        return busy;
    }
    
    public void paint(Graphics g,int x, int y, int size){
        setBounds(x, y, size, size);
        
        g.setColor(boardColor);
        g.fillRect(x, y, size, size);
        
        
        if(parent.getSelectedCell() == this){
            g.setColor(selectionColor);
            g.fillOval(x, y, size, size);
        }
        else if(parent.getHighlightedCell()== this){
            g.setColor(highlightedColor);
            g.fillOval(x, y, size, size);
        }
        
        
        int pawnSize=(int)(pawnScale*size);
        int d = (int)((size-pawnSize)/2);
        if(busy){
            g.setColor(pawnColor);
            g.fillOval(x+d, y+d, pawnSize, pawnSize);
        }
        else{
            g.setColor(boardColor);
            g.fillOval(x+d, y+d, pawnSize, pawnSize);
            g.setColor(Color.BLACK);
            g.drawOval(x+d, y+d, pawnSize, pawnSize);
        }
    }
}
