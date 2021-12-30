package com.sort_app.graphComponents;

import java.awt.*;

public class Node {
    private Point position;
    private int diameter;
    private int number;
    public static int orderNumber = 0;
    private Color m_color;
    boolean isConnected;

    private boolean m_wasVisited;

    public Node(Point position, int diameter, int number) {
        this.position = position;
        this.diameter = Math.max(diameter, 20);
        this.number = number;
        orderNumber++;
        m_wasVisited = false;
        m_color = Color.red;
        isConnected = false;
    }

    public Point getPosition() {
        return new Point(position.x, position.y);
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getDiam() {
        return diameter;
    }

    public int getRadius() {
        return diameter / 2;
    }

    ;

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return " Node : " + Integer.toString(number) + position.toString();
    }

    public boolean wasVisited() {
        return m_wasVisited;
    }

    public void setWasVisited(boolean m_wasVisited) {
        this.m_wasVisited = m_wasVisited;
    }

    public Color getColor() {
        return m_color;
    }

    public void setColor(Color m_color) {
        this.m_color = m_color;
    }

    public void markAsConnected() {
        isConnected = true;
    }

    public boolean isConnected() {
        return isConnected;
    }


}
