/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author BRudzki
 */
public class GameWindow extends JFrame{
    private GameLabel info;
    private GameMenu menu;
    private GamePanel panel;
    
    public GameWindow(String name){
        super(name);
        
        setSize(800,600);
        
        info = new GameLabel();
        panel = new GamePanel(info);
        menu = new GameMenu(this,panel);
        
        add(menu, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(info, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
