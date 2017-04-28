/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author BRudzki
 */
public class ContextMove extends JPopupMenu{
    GamePanel panel;
    BoardCell parent;
    JMenuItem left,right,up,down;
    public ContextMove(GamePanel panel, BoardCell parent){
        this.panel = panel;
        this.parent = parent;
        
        up = new JMenuItem("Move Up");
        up.addActionListener(new ClickAction(-1,0));
        
        left = new JMenuItem("Move Left");
        left.addActionListener(new ClickAction(0,-1));
        
        right = new JMenuItem("Move Right");
        right.addActionListener(new ClickAction(0,1));
        
        down = new JMenuItem("Move Down");
        down.addActionListener(new ClickAction(1,0));
        
        //add(up); add(left);
        //add(right); add(down);
    }
    
    public void prepare(){
        if(moveable(-1,0))add(up);
        else remove(up);
        
        if(moveable(0,-1))add(left);
        else remove(left);
        
        if(moveable(0,1))add(right);
        else remove(right);
        
        if(moveable(1,0))add(down);
        else remove(down);
    }
    
    private boolean moveable(int di,int dj){
        int i = parent.getI();
        int j = parent.getJ();
        BoardCell[][] board = panel.getBoard();

        if(i+2*di<0 || i+2*di>=board.length
              || j+2*dj<0 || j+2*dj>=board[i].length)
                return false;
        
        if(board[i+2*di][j+2*dj] == null)return false;
        
        if(!board[i+di][j+dj].hasPawn() || board[i+2*di][j+2*dj].hasPawn())
            return false;
        return true;
    }
    
    private class ClickAction implements ActionListener{
        int di,dj;
        public ClickAction(int di, int dj){
            this.di=di;
            this.dj=dj;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moveable(di,dj)){
                panel.select(parent);
                panel.beat(parent.getI()+2*di, parent.getJ()+2*dj);
                panel.highlight(null);
            }
        }
        
    }
    
}
