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
    private JButton button_CPM, button_posrednik, button_add;
    private JTextField name, time, prevs;
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

        welcome_text = new JLabel("Witaj! Wybierz metodę:");
        button_CPM = new JButton("CPM");
        button_posrednik = new JButton("Pośrednik");
        button_add = new JButton("Add");
        button_add.addActionListener(this);

        welcome_text.setBounds(10,10,400,25);
        button_CPM.setBounds(10,60,180,25);
        button_posrednik.setBounds(210,60,180,25);
        button_CPM.addActionListener(this);
        button_posrednik.addActionListener(this);
        panel.add(welcome_text);
        panel.add(button_CPM);
        panel.add(button_posrednik);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button_CPM){
            System.out.println("CPM");
            panel.removeAll();
            name = new JTextField("");
            time = new JTextField("");
            prevs = new JTextField("");
            name.setBounds(10,10,50,25);
            time.setBounds(70,10,50,25);
            prevs.setBounds(130,10,50,25);
            button_add.setBounds(190,10,50,25);

            panel.add(name);
            panel.add(time);
            panel.add(prevs);
            panel.add(button_add);

            if(e.getSource()==button_add) System.out.println("add");

        }
        else if (e.getSource()== button_posrednik) {
            System.out.println("posrednicy");
        }
    }
}
