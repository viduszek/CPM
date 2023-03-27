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
        frame.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/1.5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        welcome_text = new JLabel("Witaj\nwybierz metodę wprowadzania danych:");
        button_1 = new JButton("poprzednicy");
        button_2 = new JButton("kolejność zdarzeń");

        welcome_text.setBounds(10,10,400,25);
        button_1.setBounds(10,60,180,25);
        button_2.setBounds(210,60,180,25);
        button_1.addActionListener(this);
        button_2.addActionListener(this);
        panel.add(welcome_text);
        panel.add(button_1);
        panel.add(button_2);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button_1){
            System.out.println("poprzednicy");
        }
        else if (e.getSource()==button_2) {
            System.out.println("kolejnosc zdarzen");
        }
    }
}
