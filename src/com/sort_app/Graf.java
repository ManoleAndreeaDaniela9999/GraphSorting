package com.sort_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Graf extends JFrame{

    private GrafCanvas canvas;
    boolean m_isSimple;

    public Graf(boolean isSimple){

        m_isSimple = isSimple;
        System.out.println("WindOpened");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 800);
        ImageIcon menuIcon = new ImageIcon("3rdParty\\Logo.png");
        this.setIconImage(menuIcon.getImage());
        this.getContentPane().setBackground(new Color(200, 191, 231));
        this.setVisible(true);
        if (isSimple) {
            this.setTitle("Graf neorientat");
            //canvas = new GrafNeorientatCanvas();
        } else {
            this.setTitle("Graf orientat");
            //canvas = new GrafOrientatCanvas();
        }
        this.add(canvas, BorderLayout.CENTER);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
