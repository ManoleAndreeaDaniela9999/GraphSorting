package com.sort_app.tools;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;
import org.w3c.dom.NodeList;

import java.util.Stack;
import java.util.Vector;

public class DFAlgApplications {

    public static String TopSort(Vector<Node> nodeList, Vector<Arc> arcList) {
        if (nodeList.isEmpty()) return null;
        resetVisited(nodeList);
        
        Stack<Node> order = new Stack<>();

        for (Node everyNode : nodeList) {
            if(everyNode.wasVisited() == false) {
                Vector<Node> visitedNodes = new Vector<>();
                DF(everyNode, arcList, visitedNodes);
                for (Node everyVisitedNode : visitedNodes) {
                    order.addElement(everyVisitedNode);
                }
            }
        }

        //we construct the message string
        String result = "";
        while (!order.empty()) {
            result += Integer.toString(order.peek().getNumber()) + " ";
            order.pop();
        }
        return result;
    }

    private static void resetVisited(Vector<Node> nodeList) {
        for (Node n: nodeList){
            n.setWasVisited(false);
        }
    }


    private static void DF(Node currentNode, Vector<Arc> arcList, Vector<Node> visitedNodes) {

        if (currentNode.wasVisited()) return;
        currentNode.setWasVisited(true);
        Vector<Node> neighbours = new Vector<>();
        neighbours = neighboursOf(currentNode, arcList);
        System.out.println(currentNode);
        for (Node eachNeighbour : neighbours) {
            DF(eachNeighbour, arcList, visitedNodes);
        }
        visitedNodes.addElement(currentNode);
    }

    private static Vector<Node> neighboursOf(Node currentNode, final Vector<Arc> arcList) {

        Vector<Node> n = new Vector<>();
        for (Arc eachArc : arcList) {
            if (eachArc.getStartNode().getNumber() == currentNode.getNumber()) {
                n.addElement(eachArc.getEndNode());
            }
        }
        return n;
    }
}
