package com.sort_app.graphComponents;

public class Arc {

    Node m_startNode;
    Node m_endNode;

    public Arc(Node startNode, Node endNode){
        m_startNode = startNode;
        m_endNode = endNode;
    }
    public void  setStartNode(Node node){
        m_startNode = node;
    }
    public void  setEndNode(Node node){
        m_endNode = node;
    }
    public Node getStartNode(){
        return m_startNode;
    }
    public Node getEndNode(){
        return m_endNode;
    }
}
