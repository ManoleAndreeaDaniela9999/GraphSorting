package com.sort_app;

import com.sort_app.graphComponents.Arc;
import com.sort_app.graphComponents.Node;

import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.util.List;

public class GraphicsDrawMethods {

    public static boolean DrawNode(Node node, Graphics g) {
        if (Node.orderNumber > 99) {
            System.out.println("Max node number reached! ");
            return false;
        }
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.BOLD, node.getRadius()));
        g.fillOval(node.getPosition().x - node.getRadius(), node.getPosition().y - node.getRadius(), node.getDiam(), node.getDiam());
        g.setColor(Color.WHITE);
        g.drawOval(node.getPosition().x - node.getRadius(), node.getPosition().y - node.getRadius(), node.getDiam(), node.getDiam());
        if (node.getNumber() < 10)
            g.drawString("0" + node.getNumber(), node.getPosition().x - node.getRadius() / 2,
                    node.getPosition().y + node.getRadius() / 2);
        else
            g.drawString("" + node.getNumber(), node.getPosition().x - node.getRadius() / 2,
                    node.getPosition().y + node.getRadius() / 2);
        return true;
    }

    public static void DrawSimpleArc(Arc arc, Graphics g) {

        Point startPos = new Point(arc.getStartNode().getPosition());
        Point endPos = new Point(arc.getEndNode().getPosition());

        g.setColor(Color.black);
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);

    }

    public static void DrawOrientedArc(Arc arc, Graphics g) {

        Point startPos = new Point(arc.getStartNode().getPosition());
        Point endPos = new Point(arc.getEndNode().getPosition());
        g.setColor(Color.BLUE);
        //we find the point of intersection between arrow's body and endNode

        Point intersectionPoint = new Point();
        double minDist = Double.MAX_VALUE;
        try {
            List<Point2D> results = intersection(startPos, endPos, endPos, arc.getEndNode().getRadius(), true);
            for (Point2D point : results) {
                double dist = Point.distance(startPos.getX(), startPos.getY(), point.getX(), point.getY());
                if (dist < minDist) {
                    minDist = Math.min(dist, minDist);
                    intersectionPoint.setLocation(point.getX(), point.getY());
                }
                //we draw the arrow
                drawArrowLine(g , (int)startPos.getX(),(int) startPos.getY(),(int) intersectionPoint.getX(),(int) intersectionPoint.getY(), 20 , 10);

            }

        } catch (NoninvertibleTransformException e) {
            e.printStackTrace();
        }


    }

    public static void DrawLine(Point startPos, Point endPos, Graphics g) {
        g.setColor(Color.black);
        g.drawLine(startPos.x, startPos.y, endPos.x, endPos.y);
    }

    private static List<Point2D> intersection(Point p1, Point p2, Point center,
                                              double radius, boolean isSegment) throws NoninvertibleTransformException {
        List<Point2D> result = new ArrayList<>();
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        AffineTransform trans = AffineTransform.getRotateInstance(dx, dy);
        trans.invert();
        trans.translate(-center.getX(), -center.getY());
        Point2D p1a = trans.transform(p1, null);
        Point2D p2a = trans.transform(p2, null);
        double y = p1a.getY();
        double minX = Math.min(p1a.getX(), p2a.getX());
        double maxX = Math.max(p1a.getX(), p2a.getX());
        if (y == radius || y == -radius) {
            if (!isSegment || (0 <= maxX && 0 >= minX)) {
                p1a.setLocation(0, y);
                trans.inverseTransform(p1a, p1a);
                result.add(p1a);
            }
        } else if (y < radius && y > -radius) {
            double x = Math.sqrt(radius * radius - y * y);
            if (!isSegment || (-x <= maxX && -x >= minX)) {
                p1a.setLocation(-x, y);
                trans.inverseTransform(p1a, p1a);
                result.add(p1a);
            }
            if (!isSegment || (x <= maxX && x >= minX)) {
                p2a.setLocation(x, y);
                trans.inverseTransform(p2a, p2a);
                result.add(p2a);
            }
        }
        return result;
    }

    private static void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }
}
