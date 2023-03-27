package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Application implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel welcome_text;
    private JButton button_1, button_2;
    private List<Node> nodes;
    //implement main function here
    public static void main(String[] args) {
        Application application = new Application();
    }

    public Application(){
        frame = new JFrame("CPM application");
        panel = new JPanel();
        frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/0.75));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        welcome_text = new JLabel("Witaj\nwybierz metode wprowadzania danych:");
        button_1 = new JButton("metoda wprowadzania 1");
        button_2 = new JButton("metoda wprowadzania 2");

        welcome_text.setBounds(10,20,400,100);
        button_1.setBounds(10,40,60,25);
        button_2.setBounds(100,40,60,25);

        panel.add(welcome_text);
        panel.add(button_1);
        panel.add(button_2);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
