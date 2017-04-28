/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.AncestorListener;

/**
 *
 * @author BRudzki
 */
public class SettingsSubmenu extends JMenu{
    private JColorChooser backgroundColorChooser;
    public SettingsSubmenu(GamePanel panel, String name){
        super(name);
        
        JRadioButtonMenuItem british = new JRadioButtonMenuItem("British Board",true);
        JRadioButtonMenuItem european = new JRadioButtonMenuItem("European Board");
        
        british.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(panel.isPlaying()){
                    british.setSelected(!british.isSelected());
                    return;
                }
                
                european.setSelected(!british.isSelected());
                panel.setGameMode(british.isSelected());;
            }
        });
        european.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(panel.isPlaying()){
                    european.setSelected(!european.isSelected());
                    return;
                }
                
                british.setSelected(!european.isSelected());
                panel.setGameMode(british.isSelected());
            }
        });
        
        add(british);
        add(european);
        
        JMenu backgroundColor = new JMenu("Background Color");
        backgroundColorChooser = new JColorChooser(Color.WHITE);
        JMenuItem okButton = new JMenuItem("Set");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePanel.backgroundColor = backgroundColorChooser.getColor();
                panel.repaint();
            }
        });
        backgroundColor.add(backgroundColorChooser);
        backgroundColor.add(okButton);
        add(backgroundColor);
        
        
        JMenu tableColor = new JMenu("Table Color");
        JColorChooser tableColorChooser = new JColorChooser(Color.WHITE);
        okButton = new JMenuItem("Set");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameBoard.tableColor = tableColorChooser.getColor();
                panel.repaint();
            }
        });
        tableColor.add(tableColorChooser);
        tableColor.add(okButton);
        add(tableColor);
        
        JMenu boardColor = new JMenu("Board Color");
        JColorChooser boardColorChooser = new JColorChooser(Color.WHITE);
        okButton = new JMenuItem("Set");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardCell.boardColor = boardColorChooser.getColor();
                panel.repaint();
            }
        });
        boardColor.add(boardColorChooser);
        boardColor.add(okButton);
        add(boardColor);
        
        JMenu pawnsColor = new JMenu("Pawns Color");
        JColorChooser pawnsColorChooser = new JColorChooser(Color.WHITE);
        okButton = new JMenuItem("Set");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardCell.pawnColor = pawnsColorChooser.getColor();
                panel.repaint();
            }
        });
        pawnsColor.add(pawnsColorChooser);
        pawnsColor.add(okButton);
        add(pawnsColor);
    }
}
