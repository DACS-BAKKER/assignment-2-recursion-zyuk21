import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

public class HumanPyramids {
    private static int counter = 0;

    public static void main(String[] args) {
        int row = 20;
        int col = 9;
        long before, after;

        // Solve with recursion
        before = System.currentTimeMillis();

        System.out.println(wob(row, col));

        System.out.println("Recursion Calls: " + counter);
        after = System.currentTimeMillis();
        System.out.println("Time Taken (ms): " + (after - before));

        counter = 0;

        before = System.currentTimeMillis();

        System.out.println(wobWrapper(row, col));

        System.out.println("Recursion Calls: " + counter);
        after = System.currentTimeMillis();
        System.out.println("Time Taken (ms): " + (after - before));

    }

    public static double wobWrapper(int row, int col) {
        double tracker[][] = new double[row + 1][col + 1];
        return wobMemoization(row, col, tracker);
    }

    public static double wobMemoization(int row, int col, double tracker[][]) {
        counter++;
        if (row <= 0)
            return 0;
        else if (col == row && tracker[row][col] == 0)
            tracker[row][col] = (200 + wobMemoization(row - 1, col - 1, tracker)) / 2;
        else if (col == 0 && tracker[row][col] == 0)
            tracker[row][col] = (200 + wobMemoization(row - 1, col, tracker)) / 2;
        else if (tracker[row][col] == 0)
            tracker[row][col] = (400 + wobMemoization(row - 1, col, tracker) + wobMemoization(row - 1, col - 1, tracker)) / 2;
        return tracker[row][col];
    }

    public static double wob(int row, int col) {
        counter++;
        if (row <= 0)
            return 0;
        else if (col == row)
            return (200 + wob(row - 1, col - 1)) / 2;
        else if (col == 0)
            return (200 + wob(row - 1, col)) / 2;
        else
            return (400 + wob(row - 1, col) + wob(row - 1, col - 1)) / 2;
    }
}
