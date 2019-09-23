import edu.princeton.cs.algs4.*;

public class SummingDigits {
    public static void main(String[] args) {
        long before, after, line = StdIn.readLong();

        // Solve with recursion
        before = System.currentTimeMillis();
        StdOut.println(addR(line));
        after = System.currentTimeMillis();
        System.out.println("Time Taken (ms): " + (after - before));

        // Solve with while loop
        before = System.currentTimeMillis();
        System.out.println(add(line));
        after = System.currentTimeMillis();
        System.out.println("Time Taken (ms): " + (after - before));
    }

    public static long addR(long i) {
        if (i == 0)
            return i;
        else
            return i % 10 + addR(i / 10);
    }

    public static long add(long i) {
        long total = 0;

        while (i != 0) {
            total = total + i % 10;
            i = i / 10;
        }
        return total;
    }

}
