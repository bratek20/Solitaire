/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samotnik;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author BRudzki
 */
public class GameMenu extends JMenuBar{
    public GameMenu(GameWindow window, GamePanel panel){     
        add(new GameSubmenu(window, panel, "Game"));
        add(new MovesSubmenu(panel, "Moves"));
        add(new SettingsSubmenu(panel, "Settings"));
        add(Box.createHorizontalGlue());
        add(new HelpSubmenu("Help"));
    }
}
