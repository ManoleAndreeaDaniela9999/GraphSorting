package com.sort_app;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    private JPanel titlePanel;
    private JPanel buttonsPanel;
    private Button orientedGraf;
    private Button simpleGraf;
    public static int subWinRefCount;

//    public static Graf m_grafOrientat;
//    public static Graf m_grafNeorientat;

    public MainMenu() {
        subWinRefCount = 0;
        this.setTitle("Graf menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 500);
        this.getContentPane().setBackground(new Color(200, 191, 231));
        InitPanels();
        MakeTitle();
        MakeButtons();
        this.setLayout(null);
        this.setVisible(true);
        subWinRefCount = 0;
        //m_grafOrientat = null;
        //m_grafNeorientat = null;
    }

    private void MakeButtons() {
        orientedGraf = new Button("Graf Orientat");
        // orientedGraf.setBounds(150,100, 420, 50 );
        orientedGraf.setFont(new Font("Comic Sans", Font.BOLD, 25));
        orientedGraf.setSize(420, 100); // ????
        orientedGraf.setForeground(Color.CYAN);
        orientedGraf.setBackground(new Color(255, 18, 89));
        orientedGraf.setFocusable(false);
        orientedGraf.addActionListener(this);

        simpleGraf = new Button("Graf Neorientat");
        //simpleGraf.setBounds(150,300, 100 ,50);
        simpleGraf.setFocusable(false);
        simpleGraf.setFont(new Font("Comic Sans", Font.BOLD, 25));
        simpleGraf.setSize(420, 100);
        simpleGraf.setForeground(Color.CYAN);
        simpleGraf.setBackground(new Color(255, 18, 89));
        simpleGraf.addActionListener(this);

        buttonsPanel.add(orientedGraf, BorderLayout.CENTER);
        buttonsPanel.add(simpleGraf, BorderLayout.CENTER);
    }

    private void MakeTitle() {
        JLabel title = new JLabel("Graf sorting application");
        title.setSize(30, 30);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        Color titleColor = new Color(255, 18, 89);
        title.setForeground(titleColor);
        title.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        Border titleBorder = BorderFactory.createLineBorder(titleColor, 3);
        title.setBorder(titleBorder);
        titlePanel.add(title);
    }

    private void InitPanels() {
        titlePanel = new JPanel();
        titlePanel.setBounds(0, 75, 420, 100);
        titlePanel.setOpaque(false);
        buttonsPanel = new JPanel();
        buttonsPanel.setBounds(60, 200, 300, 200);
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (subWinRefCount > 0) System.out.println("A window is already opened");
        else {
            if (e.getSource() == orientedGraf) {
                GrafFactory.initGraf(false);
                System.out.println("You created oriented graph. \n ");
                subWinRefCount = 1;
                // m_grafNeorientat = null;
            }
            if (e.getSource() == simpleGraf) {
                GrafFactory.initGraf(true);
                System.out.println("You created simple graph. \n ");
                subWinRefCount = 1;
            }
        }
    }

    public static void resetSubWinRefCount() {
        subWinRefCount = 0;
    }
}
