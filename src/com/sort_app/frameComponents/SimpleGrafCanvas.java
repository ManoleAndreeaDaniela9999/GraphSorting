package com.sort_app.frameComponents;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;

import java.awt.*;
import java.util.Vector;

public class SimpleGrafCanvas extends GrafCanvas {

    public SimpleGrafCanvas(){

        nodeList = new Vector<Node>();
        arcList = new Vector<Arc>();
        this.setBackground(new Color(200, 191, 231));
        //grafNeorientatMouseAdapter = new GrafNeorientatMouseAdapter();
//        this.addMouseListener(grafNeorientatMouseAdapter);
//        this.addMouseMotionListener(grafNeorientatMouseAdapter);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Arc arc :
                arcList) {
            //GraphicsDrawMethods.DrawSimpleArc(arc, g);
        }
        for (Node node :
                nodeList) {
            //GraphicsDrawMethods.DrawNode(node, g);
        }
    }
    @Override
    public void addNode(Node node) {
        nodeList.addElement(node);
    }

    @Override
    public Vector<Node> getNodeList() {
        return nodeList;
    }

    @Override
    public void addArc(Arc arc) {

        for(Arc aux : arcList )
        {
            if(aux.getStartNode().getPosition().equals( arc.getStartNode().getPosition()) &&
                    aux.getEndNode().getPosition().equals(arc.getEndNode().getPosition()) && aux != arc )
            {
                System.out.println("Arc from" + arc.getStartNode() + "to" + arc.getEndNode() + "already exits !");
                return;
            }
        }
        arcList.addElement(arc);
    }

    @Override
    public Vector<Arc> getArcList() {
        return arcList;
    }
}
