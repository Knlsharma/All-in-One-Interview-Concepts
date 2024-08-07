package Backtracking.ClassicalExample;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 08/06/24, Saturday
 **/

//TC : O(N*target)
public class CombinationSum4 {

    public int n;
    public int[][] t;

    // Recursive function to solve the problem using memoization.
    public int solve1(int[] nums, int target, int idx) {
        // Base case: if target is 0, there's one valid combination (an empty set).
        if (target == 0)
            return 1;

        // Base case: if index is out of bounds or target becomes negative, no valid combination.
        if (idx >= n || target < 0)
            return 0;

        // Check if the solution for the current target and index is already computed.
        if (t[target][idx] != -1)
            return t[target][idx];

        // Recursive call: include the current number (reset index to 0 for repetition).
        int takeIdx = solve1(nums, target - nums[idx], 0);

        // Recursive call: exclude the current number (move to the next index).
        int rejectIdx = solve1(nums, target, idx + 1);

        // Store the result in the memoization table and return the result.
        return t[target][idx] = takeIdx + rejectIdx;
    }

    // Main function to initialize variables and start the recursive solution.
    public int combinationSum4Via1(int[] nums, int target) {
        n = nums.length; // Get the size of the nums array.
        t = new int[target + 1][n + 1]; // Initialize memoization table with appropriate size.

        // Initialize the memoization table with -1 to indicate uncomputed states.
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }

        // Start the recursive solution.
        return solve1(nums, target, 0);
    }


    //TC : O(N*target)
    // /*  Approach -2 */
    public int solve2(int idx, int[] nums, int target) {
        if (target == 0)
            return 1;

        if (idx >= n || target < 0)
            return 0;

        int result = 0;

        if (t[target][idx] != -1)
            return t[target][idx];

        // reject ka kaam for loop will handle
        for (int i = idx; i < n; i++) {
            int takeI = solve2(0, nums, target - nums[i]);
            result += takeI;
        }

        return t[target][idx] = result;
    }

    public int combinationSum4Via2(int[] nums, int target) {
        n = nums.length;
        t = new int[target + 1][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve2(0, nums, target);
    }


}

