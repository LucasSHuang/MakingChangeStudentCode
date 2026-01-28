import java.util.ArrayList;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Lucas
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {

        ArrayList<Integer> solutions = new ArrayList<Integer>();
        return 0;
    }

    public static ArrayList<Integer> findSolution(int target, int[] coins, ArrayList<Integer> path, int count) {
        if (count == target) {
            return path;
        }
        if (count > target) {
            return null;
        }
        for (int i = 0; i < coins.length; i++) {
            ArrayList<Integer> tempPath = path;
            tempPath.add(coins[i]);
            findSolution(target, coins, tempPath, count + coins[i]);
        }

        return path;
    }
}
