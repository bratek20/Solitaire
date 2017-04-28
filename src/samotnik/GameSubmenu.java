/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author BRudzki
 */
public class GameSubmenu extends JMenu{
    public GameSubmenu(GameWindow window, GamePanel panel,  String name){
        super(name);
        
        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.startNewGame();
            }
        });
        newGame.setMnemonic(KeyEvent.VK_N);
        add(newGame);
        
        addSeparator();
        
        JMenuItem endGame = new JMenuItem("End Current Game");
        endGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.endGame();
            }
        });
        endGame.setMnemonic(KeyEvent.VK_E);
        add(endGame);
        
        addSeparator();
        
        JMenuItem closeGame = new JMenuItem("Close");
        closeGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
            }
        });
        closeGame.setMnemonic(KeyEvent.VK_C);
        add(closeGame);
    }
}
