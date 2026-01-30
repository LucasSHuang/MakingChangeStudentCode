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

        long[][] counts = new long[coins.length][target + 1];
        long solution = findSolution(coins, target, counts, coins.length - 1);
        return solution;
    }

    public static long findSolution(int[] coins, int target, long[][] counts, int index) {
        if (target == 0) {
            return 1;
        }
        else if (target < 0) {
            return 0;
        }
        else if (index < 0) {
            return 0;
        }
        else if (counts[index][target] != 0) {
            return counts[index][target];
        }
        int coin = coins[index];
        long keep = findSolution(coins, target - coin, counts, index);
        long skip = findSolution(coins, target, counts, index - 1);
        counts[index][target] = keep + skip;
        return counts[index][target];
    }
}
