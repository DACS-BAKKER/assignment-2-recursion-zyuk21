/*
Name: Alex Yuk
Problem: Sierpinski Triangle
 */

import edu.princeton.cs.algs4.*;

public class TheSierpinskiTriangle {
    public static void main (String[]args) {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setPenColor(StdDraw.BLACK);
        drawSierpinskiTriangle(0.1, 0.1, 0.8, 5);
    }

    public static void drawSierpinskiTriangle(double x, double y, double side_length, int order) {
        if (order <= 0) {
            // Printing out the coordinates of the triangle drawn
            System.out.println((x + side_length / 2) + ", " + (side_length / 2  * Math.sqrt(3) + y));
            StdDraw.line(x, y, x + side_length, y);
            StdDraw.line(x, y, x + side_length / 2, side_length / 2 * Math.sqrt(3) + y);
            StdDraw.line(x + side_length, y,x + side_length / 2, side_length / 2  * Math.sqrt(3) + y);
        }
        else {
            drawSierpinskiTriangle(x, y, side_length / 2, order - 1);
            drawSierpinskiTriangle(x + side_length / 2, y, side_length / 2, order - 1);
            drawSierpinskiTriangle(x + side_length / 4, y + side_length / 4 * Math.sqrt(3), side_length / 2, order - 1);
        }
    }
}
