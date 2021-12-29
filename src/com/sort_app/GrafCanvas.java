package com.sort_app;

import javax.swing.*;
import java.util.Vector;

abstract class GrafCanvas extends JPanel {

    public abstract void addNode(Node node);
    public abstract Vector<Node> getNodeList();

    public abstract void addArc(Arc arc);
    public abstract Vector<Arc> getArcList();
}
