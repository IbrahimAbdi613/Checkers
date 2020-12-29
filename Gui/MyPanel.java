package Checkers.Gui;
import Checkers.Backend.Game;

import java.awt.*;
import javax.swing.*;
public class MyPanel extends JLayeredPane {
    Game game;

    MyPanel(Game game){
        this.game = game;
        this.setPreferredSize(new Dimension(1600,1000));
        this.setMinimumSize(new Dimension(1600, 1000));
        this.setBounds(0,0,1600,1000);

    }
    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.RED);

        for (int i = 0; i < game.Red.length; i ++){
            int x = 320 + game.Red[i].x * (125);
            int y = 20 + game.Red[i].y * (125);
            graphics2D.fillOval(x,y,75,75);
        }
        graphics2D.setPaint(Color.WHITE);
        for (int i = 0; i < game.White.length; i ++){
            int x = 320 + game.White[i].x * (125);
            int y = 20 + game.White[i].y * (125);
            graphics2D.fillOval(x,y,75,75);
        }

    }
}
