package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel welcome_text;
    private JButton button_1, button_2, add;
    private List<Action> actions = new ArrayList<>();
    private List<JTextField> insertData = new ArrayList<>();
    private JTable actions_table = new JTable();
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

        welcome_text = new JLabel("Witaj\nwybierz metode:");
        button_1 = new JButton("CPM - poprzednicy");
        button_2 = new JButton("metoda wprowadzania 2");
        add = new JButton("Add");
        insertData = new ArrayList<>();
        for (int i = 0; i < 3; i++) insertData.add(new JTextField(10));


        welcome_text.setBounds(10,20,400,100);
        button_1.setBounds(10,40,200,25);
        button_2.setBounds(300,40,200,25);
        button_1.addActionListener(this);
        add.addActionListener(this);

        panel.add(welcome_text);
        panel.add(button_1);
        panel.add(button_2);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button_1){
            panel.removeAll();
            welcome_text.setText("Wpisz:\nnazwe czynnosci\nczas trwania\npoprzednicy");
            panel.add(welcome_text);
            insertData.get(0).setBounds(40,140,150,40);
            insertData.get(1).setBounds(40,200,150,40);
            insertData.get(2).setBounds(40,260,150,40);
            add.setBounds(40,320,150,40);
            add.setText("Add");
            panel.add(add);
            for (int i =0;i<3;i++) panel.add(insertData.get(i));
            panel.repaint();
        }
        else if (e.getSource()==add) {
            String[] columns = {"nazwa","czas trwania","Poprzednie czynnosci"};
            List<String[]> tmp_data = new ArrayList<>();
            String tmp_name;
            int tmp_time;
            String tmp_prev_actions;
            tmp_name = insertData.get(0).getText();
            tmp_time = Integer.parseInt(insertData.get(1).getText());
            tmp_prev_actions = insertData.get(2).getText();
            actions.add(new Action(tmp_prev_actions,tmp_time,tmp_name));
            for (int i =0;i<3;i++) insertData.get(i).setText("");
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i));
                tmp_data.add( actions.get(i).robocza_nazwa_1());
            }


            String[][] data = new String[tmp_data.size()][];
            for (int i = 0; i < tmp_data.size(); i++) {
                String[] array = tmp_data.get(i);
                data[i] = Arrays.copyOf(array, array.length);
            }
            actions_table = new JTable(data,columns);
            actions_table.setVisible(true);
            actions_table.setBounds(40,370,400,400);
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(actions_table);
            try {
                panel.remove(actions_table);
                panel.remove(scrollPane);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            panel.add(actions_table);
            //panel.add(scrollPane);
            panel.repaint();
        }
    }
}
