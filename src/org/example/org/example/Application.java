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
    private JButton button_1, button_2, add, start_again, confirm;
    private List<Action> actions = new ArrayList<>();
    private List<JTextField> insertData = new ArrayList<>();
    private JTable actions_table = new JTable();

    // implement main function here
    public static void main(String[] args) {
        Application application = new Application();
    }

    public Application() {
        frame = new JFrame("Badania Operacyjne i Logistyka");
        panel = new JPanel();
        frame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 0.75));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        welcome_text = new JLabel("Select program solving method:");
        button_1 = new JButton("CPM - Previous Actions");
        button_2 = new JButton("TBD (2nd method)");
        add = new JButton("Add");
        start_again = new JButton("Start Again");
        confirm = new JButton("Confirm Data");
        insertData = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            insertData.add(new JTextField(10));

        welcome_text.setBounds(10, 20, 400, 100);
        button_1.setBounds(10, 40, 200, 25);
        button_2.setBounds(300, 40, 200, 25);
        button_1.addActionListener(this);
        add.addActionListener(this);
        confirm.addActionListener(this);
        start_again.addActionListener(this);

        panel.add(welcome_text);
        panel.add(button_1);
        panel.add(button_2);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_1) {
            panel.removeAll();
            welcome_text.setText("Enter: Action Name, Duration, Previous Actions");
            panel.add(welcome_text);
            insertData.get(0).setBounds(40, 140, 150, 40);
            insertData.get(1).setBounds(40, 200, 150, 40);
            insertData.get(2).setBounds(40, 260, 150, 40);
            add.setBounds(40, 320, 150, 40);
            add.setText("Add");
            panel.add(add);
            for (int i = 0; i < 3; i++)
                panel.add(insertData.get(i));
            panel.repaint();
        } else if (e.getSource() == add) {
            panel.removeAll();
            String[] columns = new String[] { "ID", "Name", "Duration", "Previous Actions" };
            List<String[]> tmp_data = new ArrayList<>();
            String tmp_name;
            int tmp_time;
            String tmp_prev_actions;
            tmp_name = insertData.get(0).getText();
            tmp_time = Integer.parseInt(insertData.get(1).getText());
            tmp_prev_actions = insertData.get(2).getText();
            if (tmp_time > 0)
                actions.add(new Action(tmp_prev_actions, tmp_time, tmp_name));
                actions.get(actions.size()-1).set_id(actions.size()-1);
            for (int i = 0; i < 3; i++) {
                insertData.get(i).setText("");
                panel.add(insertData.get(i));
            }
            for (int i = 0; i < actions.size(); i++) {
                System.out.println(actions.get(i));
                tmp_data.add(actions.get(i).robocza_nazwa_1());
            }

            String[][] data = new String[tmp_data.size()][];
            for (int i = 0; i < tmp_data.size(); i++) {
                String[] array = tmp_data.get(i);
                data[i] = Arrays.copyOf(array, array.length);
            }
            actions_table = new JTable(data, columns);
            actions_table.setBounds(40, 370, 400, 400);
            start_again.setBounds(40, 780, 200, 40);
            confirm.setBounds(250, 780, 200, 40);
            // JScrollPane scrollPane = new JScrollPane();
            // scrollPane.setViewportView(actions_table);

            actions_table.setVisible(true);
            panel.add(add);
            panel.add(welcome_text);
            panel.add(actions_table);
            panel.add(start_again);
            panel.add(confirm);
            // panel.add(scrollPane);
            panel.repaint();
        } else if (e.getSource() == start_again) {
            panel.removeAll();
            System.out.println("START AGAIN BUTTON");
            String[] columns = new String[] { "ID", "Name", "Duration", "Previous Actions" };
            List<String[]> tmp_data = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                insertData.get(i).setText("");
                panel.add(insertData.get(i));
            }
            actions.clear();
            if (actions.size() > 0) {
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(actions.get(i));
                    tmp_data.add(actions.get(i).robocza_nazwa_1());
                }
            } else
                tmp_data.add(new String[] { "", "", "", "" });
            String[][] data = new String[tmp_data.size()][];
            for (int i = 0; i < tmp_data.size(); i++) {
                String[] array = tmp_data.get(i); 
                data[i] = Arrays.copyOf(array, array.length);
            }
            actions_table = new JTable(data, columns);

            actions_table.setBounds(40, 370, 400, 400);
            start_again.setBounds(40, 780, 200, 40);
            confirm.setBounds(250, 780, 200, 40);
            // JScrollPane scrollPane = new JScrollPane();
            // scrollPane.setViewportView(actions_table);

            actions_table.setVisible(true);
            panel.add(add);
            panel.add(welcome_text);
            panel.add(actions_table);
            panel.add(start_again);
            panel.add(confirm);
            // panel.add(scrollPane);
            panel.repaint();
        } else if (e.getSource() == confirm) {
            System.out.println("CONFIRM BUTTON");
            panel.removeAll();
            panel.repaint();
        }
    }
}
