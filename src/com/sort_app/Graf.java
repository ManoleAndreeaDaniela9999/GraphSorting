package com.sort_app;

import com.sort_app.factories.GrafCanvasFactory;
import com.sort_app.factories.MouseAdapterFactory;
import com.sort_app.frameComponents.GrafCanvas;
import com.sort_app.graphComponents.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graf extends JFrame implements ActionListener {

    public static GrafCanvas canvas;
    private boolean m_isSimple;
    private String m_title;
    private MouseAdapter m_mAdapter;
    private JMenuBar m_menuBar;

    public Graf(boolean isSimple) {

        m_isSimple = isSimple;
        System.out.println("WindOpened");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 800);
        ImageIcon menuIcon = new ImageIcon("3rdParty\\Logo.png");
        this.setIconImage(menuIcon.getImage());
        this.getContentPane().setBackground(new Color(200, 191, 231));
        if (isSimple) {
            m_title = "Graf neorientat";
            this.setTitle("Graf neorientat");
        } else {
            m_title = "Graf orientat";
            this.setTitle("Graf orientat");
        }
        canvas = GrafCanvasFactory.initGrafCanvas(isSimple);
        m_mAdapter = MouseAdapterFactory.initCanvasMouseAdapter(isSimple);
        canvas.addMouseListener(m_mAdapter);
        canvas.addMouseMotionListener(m_mAdapter);
        this.add(canvas, BorderLayout.CENTER);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

                System.out.println("You opened \"" + m_title + "\" window");
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("window closed");
                MainMenu.resetSubWinRefCount();
                Node.orderNumber = 0;
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
        m_menuBar = new JMenuBar();

        JMenu connectedComponentsMenu = new JMenu("Preview connected components");
        JMenu topologicalSorting = new JMenu("Preview topological Sorting");

        m_menuBar.add(connectedComponentsMenu);
        m_menuBar.add(topologicalSorting);
        
        this.setJMenuBar(m_menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
