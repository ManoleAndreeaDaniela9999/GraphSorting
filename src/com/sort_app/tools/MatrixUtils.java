package com.sort_app.tools;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MatrixUtils {

    private static String m_filePath;

    public static void setFilePath(String filePath) {

        m_filePath = filePath;
    }

    public static void ConstructMatrix(List<Node> nodeList, List<Arc> arcList, boolean isOriented) {
        try {

            if (isOriented) {
                grafOrientatMatrix(nodeList, arcList);
            } else {
                grafNeorientatMatrix(nodeList, arcList);
            }
        } catch (IOException e) {
            System.out.println("Error writing file! ");
        }
    }

    ;

    public static void grafOrientatMatrix(List<Node> nodeList, List<Arc> arcList) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("graforientat.txt"));

        writer.write(String.valueOf(nodeList.size()));
        writer.newLine();
        int row, column;
        for (row = 0; row < nodeList.size(); row += 1) {
            for (column = 0; column < nodeList.size(); column += 1) {
                if (listContainsArc(row, column, arcList))
                    writer.write('1');
                else
                    writer.write('0');
                ;
            }
            writer.newLine();
        }
        writer.flush();

        writer.close();
    }

    public static void grafNeorientatMatrix(List<Node> nodeList, List<Arc> arcList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("grafneorientat.txt"));

        writer.write(String.valueOf(nodeList.size()));
        writer.newLine();
        int row, column;
        for (row = 0; row < nodeList.size(); row += 1) {
            for (column = 0; column < nodeList.size(); column += 1) {
                if (listContainsArc(row, column, arcList) || listContainsArc(column, row, arcList))
                    writer.write('1');
                else
                    writer.write('0');
                ;
            }
            writer.newLine();
        }
        writer.flush();

        writer.close();
    }

    private static boolean listContainsArc(int node1Nr, int node2Nr, List<Arc> arcList) {

        if (node1Nr == node2Nr) return false;
        for (Arc arc : arcList) {
            if (node1Nr == arc.getStartNode().getNumber() && node2Nr == arc.getEndNode().getNumber())
                return true;
        }
        return false;
    }
}
