package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import org.graphstream.graph.*;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.spriteManager.*;
//import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.*;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.layout.springbox.implementations.LinLog;
import org.graphstream.ui.view.ViewerPipe;

import static org.example.CriticalPath.criticalPath;

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
        frame.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 1.5));
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
            welcome_text.setText("    Action Name         Duration                 Next Actions");
            panel.add(welcome_text);
            insertData.get(0).setBounds(20, 90, 100, 40);
            insertData.get(1).setBounds(140, 90, 100, 40);
            insertData.get(2).setBounds(260, 90, 100, 40);
            add.setBounds(20, 150, 100, 40);
            add.setText("Add");
            panel.add(add);
            for (int i = 0; i < 3; i++)
                panel.add(insertData.get(i));
            panel.repaint();
        } else if (e.getSource() == add) {
            panel.removeAll();
            String[] columns = new String[]{"ID", "Name", "Duration", "Previous Actions"};
            List<String[]> tmp_data = new ArrayList<>();
            String tmp_name;
            int tmp_time;
            String tmp_prev_actions;
            tmp_name = insertData.get(0).getText();
            tmp_time = Integer.parseInt(insertData.get(1).getText());
            tmp_prev_actions = insertData.get(2).getText();
            if (tmp_time >= 0)
                actions.add(new Action(tmp_prev_actions, tmp_time, tmp_name));
            actions.get(actions.size() - 1).set_id(actions.size() - 1);
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
            actions_table.setBounds(20, 200, 400, 250);
            start_again.setBounds(30, 475, 180, 40);
            confirm.setBounds(230, 475, 180, 40);
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
            String[] columns = new String[]{"ID", "Name", "Duration", "Previous Actions"};
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
                tmp_data.add(new String[]{"", "", "", ""});
            String[][] data = new String[tmp_data.size()][];
            for (int i = 0; i < tmp_data.size(); i++) {
                String[] array = tmp_data.get(i);
                data[i] = Arrays.copyOf(array, array.length);
            }
            actions_table = new JTable(data, columns);

            actions_table.setBounds(20, 200, 400, 250);
            start_again.setBounds(30, 475, 180, 40);
            confirm.setBounds(230, 475, 180, 40);
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

            //HashSet<CriticalPath.Task> tasks = new HashSet<CriticalPath.Task>();
            List<CriticalPath.Task> tasks = new ArrayList<>();

            for (Action action : actions) {
                CriticalPath.Task task = new CriticalPath.Task(action.getAction_name(), action.getTime());
                tasks.add(task);
            }


            for (Action action : actions) {
                if (!action.getPrev_action().isEmpty()) {
                    String pom1 = action.getPrev_action();
                    for (int i = 0; i < action.getPrev_action().length(); i++) {
                        for (int j = 0; j < actions.size(); j++) {
                            if (String.valueOf(pom1.charAt(i)).equals(tasks.get(j).name))
                                tasks.get(action.get_id()).setDependencies(tasks.get(j));
                        }
                    }
                }
            }

            HashSet<CriticalPath.Task> hashSet = new HashSet<>();
            hashSet.addAll(tasks);

            tasks.clear();


            CriticalPath.Task[] result = criticalPath(hashSet);
            CriticalPath.print(result);

            CriticalPath.Task[] tasks2 = hashSet.toArray(new CriticalPath.Task[0]);

            for (CriticalPath.Task task : tasks2) {
                task.criticalALL();
            }


            for (CriticalPath.Task task : tasks2) {
                CriticalPath.Task[] a = task.dependencies.toArray(new CriticalPath.Task[0]);
                for (int i = 0; i < a.length; i++) {
                    System.out.println(task.name + " -> " + a[i].name);
                }

            }


//            for (CriticalPath.Task task : tasks2) {
//                System.out.println(task.name+" " +task.critical);
//            }


            Graph graph = new SingleGraph("Tutorial");

            graph.setStrict(false);
            graph.setAutoCreate(true);

            graph.addAttribute("ui.quality");
            graph.addAttribute("ui.antialias");

            //SpriteManager sman = new SpriteManager(graph);


            for (CriticalPath.Task value : tasks2) {
                String pom = value.name;
                CriticalPath.Task[] pom2 = value.dependencies.toArray(new CriticalPath.Task[0]);
                //Sprite sprite = sman.addSprite(pom);


                //if (value.critical)
                graph.addNode(pom);//.setAttribute("ui.style", "size-mode: fit; shape: rounded-box; fill-color: white; stroke-mode: plain; padding: 3px, 2px; ");
                //else graph.addNode(pom).setAttribute("ui.style", "fill-color: green;");


                if (pom2.length >= 1) {
                    for (CriticalPath.Task task : pom2) {

                        if (value.critical && task.critical) graph.addEdge(pom + task.name, pom, task.name).setAttribute("ui.style", "fill-color: red; shape: cubic-curve;");
                        else graph.addEdge(pom + task.name, pom, task.name).setAttribute("ui.style", "shape: cubic-curve;");

                    }
                }

                //   if (value.critical)

//                sprite.attachToNode(pom);
//                sprite.addAttribute("ui.label", pom);


            }

            graph.setAttribute("ui.style", "padding: 20px;");

            System.setProperty("org.graphstream.ui", "swing");

            for (Node node : graph) {

                node.setAttribute("ui.style", "text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: #222;");
                node.setAttribute("ui.label", node.getId());
            }

//            for (Edge edge : graph.getEachEdge()) {
//                  //  edge.get
//                edge.addAttribute("ui.style", "shape: freeplane;");
//            }


            //Viewer viewer = graph.display();
            Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

            final ViewPanel viewPanel = viewer.addDefaultView(true);

            viewer.enableAutoLayout();

//            ViewerPipe viewerPipe = viewer.newViewerPipe();
//            viewerPipe.addAttributeSink(graph);
//            viewer.enableAutoLayout();
//            View view = viewer.getDefaultView();
// ...
            //view.getCamera().setViewPercent(2);

            panel.add(viewPanel);
            frame.add(panel);
            frame.setVisible(true);
//            panel.repaint();
        }
    }
}




