package org.example;

import javax.swing.*;
import java.awt.*;

public class ProstaAplikacja extends JFrame {

    private int liczbaWezlow;
    private float[][] tablicaWezlow;
    private int[][] tablicaPolaczen;
    private JLabel label;
    private JPanel panel;
    private boolean isPoprzedniki;

    public ProstaAplikacja(boolean isPoprzedniki, int liczbaWezlow) {
        this.isPoprzedniki = isPoprzedniki;
        this.liczbaWezlow = liczbaWezlow;
        this.tablicaWezlow = new float[liczbaWezlow][2];
        this.tablicaPolaczen = new int[liczbaWezlow][];
        for (int i = 0; i < liczbaWezlow; i++) {
            tablicaPolaczen[i] = new int[isPoprzedniki ? (int) (Math.random() * i) : (int) (Math.random() * (liczbaWezlow - i - 1))];
            for (int j = 0; j < tablicaPolaczen[i].length; j++) {
                tablicaPolaczen[i][j] = isPoprzedniki ? (int) (Math.random() * i) : (int) (Math.random() * (liczbaWezlow - i - 1)) + i + 1;
            }
            tablicaWezlow[i][0] = (float) (Math.random() * 10);
            tablicaWezlow[i][1] = (float) (Math.random() * 10);
        }
        label = new JLabel("Wybierz węzeł:");
        panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < liczbaWezlow; i++) {
                    for (int j = 0; j < tablicaPolaczen[i].length; j++) {
                        g.drawLine((int) tablicaWezlow[i][0], (int) tablicaWezlow[i][1], (int) tablicaWezlow[tablicaPolaczen[i][j]][0], (int) tablicaWezlow[tablicaPolaczen[i][j]][1]);
                    }
                }
                for (int i = 0; i < liczbaWezlow; i++) {
                    g.fillOval((int) tablicaWezlow[i][0] - 10, (int) tablicaWezlow[i][1] - 10, 20, 20);
                    g.drawString("" + (i + 1), (int) tablicaWezlow[i][0] - 5, (int) tablicaWezlow[i][1] + 5);
                }
            }
        };
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int x = evt.getX();
                int y = evt.getY();
                for (int i = 0; i < liczbaWezlow; i++) {
                    if ((x > tablicaWezlow[i][0] - 10) && (x < tablicaWezlow[i][0] + 10) && (y > tablicaWezlow[i][1] - 10) && (y < tablicaWezlow[i][1] + 10)) {
                        StringBuilder builder = new StringBuilder();
                        builder.append("Węzeł: ").append(i + 1).append("\n");
                        builder.append("Czas trwania procesu: ").append(tablicaWezlow[i][0]).append("\n");
                        builder.append(isPoprzedniki ? "Poprzednicy: " : "Następniki: ");
                        for (int j = 0; j < tablicaPolaczen[i].length; j++) {
                            builder.append(tablicaPolaczen[i][j] + 1);
                            if (j < tablicaPolaczen[i].length - 1) {
                                builder.append(", ");
                            }
                        }
                        JOptionPane.showMessageDialog(panel, builder.toString(), "`informacje`", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ProstaAplikacja(true, 10);
    }
}
