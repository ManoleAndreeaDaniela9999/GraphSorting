package com.sort_app.tools;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import static java.lang.Math.min;

public class DFAlgApplications {

    enum SelectedOption {
        SORT,
        COMPONENTS
    }

    private static SelectedOption currentOption;
    private static Random randomise = new Random();

    public static String TopSort(Vector<Node> nodeList, Vector<Arc> arcList) {
        if (nodeList.isEmpty()) return null;
        currentOption = SelectedOption.SORT;
        Stack<Node> order = new Stack<>();

        for (Node everyNode : nodeList) {
            if (everyNode.wasVisited() == false) {
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
        resetVisited(nodeList);
        return result;
    }

    public static void PaintConnectedComponents(Vector<Node> nodeList, Vector<Arc> arcList) {

        currentOption = SelectedOption.COMPONENTS;
        for (Node currentNode : nodeList) {

            if (currentNode.wasVisited() == false) {
                Color randColor = RandomColor();
                Vector<Node> visitedNodes = new Vector<>();
                DF(currentNode, arcList, visitedNodes);
                for (Node everyVisitedNode : visitedNodes) {
                    everyVisitedNode.setColor(randColor);
                }
            }
        }
        resetVisited(nodeList);
    }

    public static void PaintStronglyConnectedComponents(Vector<Node> nodeList, Vector<Arc> arcList) {
        //This is Tarjan's alg
        //because given the data it is more suited than other variants of solving this problem

        if (nodeList.isEmpty()) return;
        Stack<Node> stack = new Stack<>();
        boolean[] onStack = new boolean[nodeList.size()];
        int[] lowLinks = new int[nodeList.size()];
        Color randColor ;
        int[] sccCount = new int[1];
        sccCount[0] = 0;
        for (Node currentNode : nodeList) {
            if (!currentNode.wasVisited())
                dfSCCVariant(currentNode, arcList, stack, onStack, lowLinks, sccCount);
        }

        while(sccCount[0] > 0){
            randColor = RandomColor();
            for (Node currentNode : nodeList) {
            if(lowLinks[currentNode.getNumber()] == sccCount[0])
                currentNode.setColor(randColor);
            }
            sccCount[0]-=1;
        }

        resetVisited(nodeList);
    }

    private static void dfSCCVariant(Node currentNode, Vector<Arc> arcList, Stack<Node> stack, boolean[] onStack, int[] lowLinks, int[] sccCount) {

        stack.push(currentNode);
        onStack[currentNode.getNumber()] = true;
        lowLinks[currentNode.getNumber()] = currentNode.getNumber();
        currentNode.setWasVisited(true);

        Vector<Node> neighbours = new Vector<>();
        neighbours = childrenOf(currentNode, arcList);

        for (Node neighbour:
             neighbours) {
            if(!neighbour.wasVisited())
                dfSCCVariant(neighbour,arcList,stack,onStack,lowLinks,sccCount);
            if(onStack[neighbour.getNumber()])
                lowLinks[currentNode.getNumber()] = min(lowLinks[currentNode.getNumber()],lowLinks[neighbour.getNumber()]);
        }

        if(currentNode.getNumber() != lowLinks[currentNode.getNumber()]) return;

        while(!stack.empty()){

            Node node = stack.pop();
            onStack[node.getNumber()] = false;
            if(node.getNumber() == currentNode.getNumber()) break;
            sccCount[0]+=1;
        }

    }

    private static Color RandomColor() {
        float r = randomise.nextFloat();
        float g = randomise.nextFloat();
        float b = randomise.nextFloat();

        return new Color(r, g, b);
    }

    private static void resetVisited(Vector<Node> nodeList) {
        for (Node n : nodeList) {
            n.setWasVisited(false);
        }
    }


    private static void DF(Node currentNode, Vector<Arc> arcList, Vector<Node> visitedNodes) {

        if (currentNode.wasVisited()) return;
        currentNode.setWasVisited(true);
        Vector<Node> neighbours = new Vector<>();
        if (currentOption == SelectedOption.SORT)
            neighbours = childrenOf(currentNode, arcList);
        else
            neighbours = neighboursOf(currentNode, arcList);
        System.out.println(currentNode);
        for (Node eachNeighbour : neighbours) {
            DF(eachNeighbour, arcList, visitedNodes);
        }
        visitedNodes.addElement(currentNode);
    }

    private static Vector<Node> neighboursOf(Node currentNode, Vector<Arc> arcList) {

        Vector<Node> n = new Vector<>();
        for (Arc eachArc : arcList) {
            if (eachArc.getStartNode().getNumber() == currentNode.getNumber()) {
                n.addElement(eachArc.getEndNode());
            } else if (eachArc.getEndNode().getNumber() == currentNode.getNumber()) {
                n.addElement(eachArc.getStartNode());
            }

        }
        return n;
    }


    private static Vector<Node> childrenOf(Node currentNode, final Vector<Arc> arcList) {

        Vector<Node> n = new Vector<>();
        for (Arc eachArc : arcList) {
            if (eachArc.getStartNode().getNumber() == currentNode.getNumber()) {
                n.addElement(eachArc.getEndNode());
            }
        }
        return n;
    }
}
