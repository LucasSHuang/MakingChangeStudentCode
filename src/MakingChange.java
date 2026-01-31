import java.util.ArrayList;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Lucas
 */

public class MakingChange {

    public static long countWays(int target, int[] coins) {

        // 2D array to keep track of already found counts
        long[][] counts = new long[coins.length][target + 1];
        for (int i = 0; i < coins.length; i++) {
            counts[i][0] = 1;
        }
        long solution = findSolution(coins, target, counts, coins.length - 1);
        return solution;
    }

    public static long findSolution(int[] coins, int target, long[][] counts, int index) {

//        // Memoization solution to the problem
//        // Base cases for if you have reached the target or past the target or there are no more coins to remove
//        if (target == 0) {
//            return 1;
//        }
//        else if (target < 0) {
//            return 0;
//        }
//        else if (index < 0) {
//            return 0;
//        }
//
//        // Check if the count is already solved for
//        if (counts[index][target] != 0) {
//            return counts[index][target];
//        }
//
//        int coin = coins[index];
//
//        // Find the solution for both keeping the current coin and subtracting it or removing the coin
//        long keep = findSolution(coins, target - coin, counts, index);
//        long skip = findSolution(coins, target, counts, index - 1);
//
//        // The sum of those is the total solutions to that spot on the 2D array
//        counts[index][target] = keep + skip;
//        return counts[index][target];

        // Tabluation Solution
        // Nested for loop to go over every spot in the 2D array
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < counts[0].length; j++) {
                // Gets the count for if you keep the number
                long keep;
                if (j - coins[i] < 0) {
                    keep = 0;
                }
                else {
                    keep = counts[i][j - coins[i]];
                }

                // Gets the count if you skip over the number
                long skip;
                if (i == 0) {
                    skip = 0;
                }
                else {
                    skip = counts[i - 1][j];
                }

                // Adds the two to get the solution at that spot
                counts[i][j] = keep + skip;
            }
        }
        return counts[coins.length - 1][target];
    }
}
