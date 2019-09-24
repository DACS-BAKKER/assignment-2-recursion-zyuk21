/*
Name: Alex Yuk
Problem: Every Vote Counts
 */

public class EveryVoteCounts {
    private static final int[] BLOCK = new int[]{2, 4, 4};
    private static final int NUM = 7;
    private static int criticalPoint;

    public static void main(String[] args) {
        criticalPoint = (sumArray(BLOCK) + NUM) / 2;
        System.out.println("Critical situations: " + countCriticalVotes(BLOCK, NUM));
    }

    private static int countCriticalVotes(int[] blocks, int block_count) {
        int count = 0;
        int current_block_sum = sumArray(blocks);
        if (blocks.length > 0) {
            int[] temp = shift(blocks);
            count += countCriticalVotes(temp, block_count);
            if (blocks.length > 1) {
                temp = skipShift(blocks);
                count += countCriticalVotes(temp, block_count);
            }
        }
        if (current_block_sum <= criticalPoint && block_count + current_block_sum > criticalPoint)
            count++;
        return count;
    }


    private static int sumArray(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++)
            total += arr[i];
        return total;
    }

    private static int[] shift(int[] blocks) {
        int[] temp = new int[blocks.length - 1];
        for (int i = 0; i < blocks.length - 1; i++)
            temp[i] = blocks[i + 1];
        return temp;
    }

    private static int[] skipShift(int[] blocks) {
        int[] temp = new int[blocks.length - 1];
        temp[0] = blocks[0];
        for (int i = 1; i < blocks.length - 1; i++)
            temp[i] = blocks[i + 1];
        return temp;
    }
}
