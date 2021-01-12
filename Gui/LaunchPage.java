package Checkers.Gui;

import Checkers.Backend.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton myButton = new JButton("New Game");
    JButton myButton1 = new JButton("Done");
    JButton myButton2 = new JButton("Done");
    int counter;

    JTextField textField;
    JTextField textField2;
    JPanel jPanel = new JPanel();
    JPanel jPanel2  = new JPanel();
    JPanel jPanel3  = new JPanel();
    JPanel jPanel4  = new JPanel();
    JPanel jPanel5  = new JPanel();

    JLabel jLabel = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();


    public LaunchPage(){
        myButton.setBounds(200,450,200,40);
        myButton.setFocusable(false);
        myButton.setBackground(Color.ORANGE);
        myButton.addActionListener(this);

        myButton1.setBounds(60,170,75,50);
        myButton1.setFocusable(false);
        myButton1.setBackground(Color.ORANGE);
        myButton1.addActionListener(this);

        myButton2.setBounds(460,170,75,50);
        myButton2.setFocusable(false);
        myButton2.setBackground(Color.ORANGE);
        myButton2.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100 ,60));
        textField.setLayout(null);
        textField.setVisible(true);

        jPanel.setBounds(50,100,100,50);
        jPanel.add(textField);
        jPanel.setBackground(new Color(17, 59 ,8 ));

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100 ,60));
        textField2.setLayout(null);
        textField2.setVisible(true);

        jPanel2.setBounds(450,100,100,50);
        jPanel2.add(textField2);
        jPanel2.setBackground(new Color(17, 59 ,8 ));


        jLabel.setText("Player 1\n");
        jPanel3.setBounds(50,50,100,30);
        jPanel3.setBackground(new Color(255, 255, 255));
        jPanel3.add(jLabel);

        jLabel2.setText("Player 2\n");
        jPanel4.setBounds(450,50,100,30);
        jPanel4.setBackground(new Color(255, 255, 255));
        jPanel4.add(jLabel2);

        //Creates the window
        frame.setPreferredSize(new Dimension(600,600));

        //Sets the title of the window as well the icon and the background colour
        frame.setTitle("LaunchPage");
        ImageIcon image = new ImageIcon("src/Checkers/Gui/Icon.jpg");
        frame.setIconImage(image.getImage());
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        frame.add(myButton);
        frame.add(myButton1);
        frame.add(myButton2);
        frame.add(jPanel);
        frame.add(jPanel2);
        frame.add(jPanel3);
        frame.add(jPanel4);

        frame.getContentPane().setBackground(new Color(17, 59 ,8 ));
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(textField.getText().isBlank()|| textField2.getText().isBlank())){
            new Game(8,textField.getText(),textField2.getText());
            frame.dispose();

        }
        else{
            jLabel3.setText("Please Enter your names in the boxes       ");
            jLabel3.setForeground(new Color(255,255,255));
            jLabel3.setFont (jLabel3.getFont ().deriveFont (20.0f));
            jPanel5.setBounds(75,300,500,200);
            jPanel5.setBackground(new Color(248, 13, 13));
            jPanel5.add(jLabel3);
            frame.add(jPanel5);
            frame.pack();
            frame.setVisible(true);
        }

    }
}
