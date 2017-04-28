/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author BRudzki
 */
public class MovesSubmenu extends JMenu{
    GamePanel panel;
    JMenuItem left,right,up,down;
    public MovesSubmenu(GamePanel panel, String name){
        super(name);
        this.panel = panel;
        
        up = new JMenuItem("Move Up");
        up.addActionListener(new ClickAction(-1,0));
        up.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.ALT_DOWN_MASK));
        
        left = new JMenuItem("Move Left");
        left.addActionListener(new ClickAction(0,-1));
        left.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
        
        right = new JMenuItem("Move Right");
        right.addActionListener(new ClickAction(0,1));
        right.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
        
        down = new JMenuItem("Move Down");
        down.addActionListener(new ClickAction(1,0));
        down.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
    
        add(up); add(left);
        add(right); add(down);
    }
    
    private boolean moveable(int di,int dj){
        BoardCell cell = panel.getSelectedCell();
        if(cell == null) return false; 
        
        int i = cell.getI();
        int j = cell.getJ();
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
                BoardCell cell = panel.getSelectedCell(); 
                panel.select(cell);
                panel.beat(cell.getI()+2*di, cell.getJ()+2*dj);
                panel.highlight(null);
            }
        }
        
    }
}
