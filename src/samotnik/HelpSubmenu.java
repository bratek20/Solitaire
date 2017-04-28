/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author BRudzki
 */
public class HelpSubmenu extends JMenu{
    public HelpSubmenu(String name){
        super(name);
        
        JMenuItem rules = new JMenuItem("Rules");
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelpSubmenu.this.getParent(), rulesText, "Rules", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(rules);
        
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HelpSubmenu.this.getParent(), aboutText, "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(about);
    }
    
    private String rulesText = "Preparation and Objective\n" +
                            "\n" +
                            "The game is set up so that pieces fill every hole except the middle hole.\n" +
                            "\n" +
                            "The objective is to remove every piece except one, with the final piece ending up in the centre hole. Solitaire is played by one person and is therefore technically not a game at all, but a puzzle.\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "Basic Play\n" +
                            "\n" +
                            "The player makes successive capturing moves, removing a single piece each turn until is it impossible to make any more capturing moves.\n" +
                            "\n" +
                            "Each turn, the player captures a piece by jumping over that piece orthogonally (not diagonally) from one adjacent point to the vacant adjacent point on the other side.\n" +
                            "\n" +
                            "Therefore, the first turn can be made only by jumping a piece into the middle hole from one of 4 possible points.\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "Advanced Play\n" +
                            "\n" +
                            "Once you have mastered the basic game, target a different hole as the hole that the final piece should finish in. You can also aim to get certain patterns of pieces left over.\n" +
                            "\n" +
                            "Interestingly, it has been deduced that the 37 point board is less complex than the 33 point board."; 

    private String aboutText = "Author: Bartosz Rudzki\n"+
                               "Version 1.0\n"+
                               "Build date: 30.11.2016\n";

}
