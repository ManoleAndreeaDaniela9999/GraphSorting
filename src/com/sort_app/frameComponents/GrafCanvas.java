package com.sort_app.frameComponents;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;

import javax.swing.*;
import java.util.Vector;

public abstract class GrafCanvas extends JPanel {

    protected Vector<Node> nodeList;
    protected Vector<Arc> arcList;


    public abstract void addNode(Node node);
    public abstract Vector<Node> getNodeList();

    public abstract void addArc(Arc arc);
    public abstract Vector<Arc> getArcList();
}
