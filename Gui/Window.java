package Checkers.Gui;

import Checkers.Backend.Game;

import java.awt.*;
import java.io.File;

import javax.swing.*;


public class Window extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Window(int width, int height, String titleString, Game game) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle(titleString);

        ImageIcon image = new ImageIcon("src/Checkers/Icon.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(245,245,220));


        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

}
