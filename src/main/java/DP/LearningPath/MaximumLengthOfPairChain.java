package DP.LearningPath;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Kunal Sharma
 * @since : 30/06/24, Sunday
 **/
public class MaximumLengthOfPairChain {
    private int n;
    private final int[][] t = new int[1001][1001];

    private int lis(int[][] nums, int prev_idx, int curr_idx) {
        if (curr_idx == n)
            return 0;

        if (prev_idx != -1 && t[prev_idx][curr_idx] != -1)
            return t[prev_idx][curr_idx];

        int taken = 0;
        if (prev_idx == -1 || nums[curr_idx][0] > nums[prev_idx][1])
            taken = 1 + lis(nums, curr_idx, curr_idx + 1);

        int not_taken = lis(nums, prev_idx, curr_idx + 1);

        if (prev_idx != -1)
            t[prev_idx][curr_idx] = Math.max(taken, not_taken);

        return Math.max(taken, not_taken);
    }

    // T.C. = O(n^2), S.C. = O(n^2) WITH MEMOIZATION
    // T.C. = O(2^n), S.C. = O(n) WITHOUT MEMOIZATION
    public int findLongestChain(int[][] pairs) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0])); // You can select pairs in any order.
        return lis(pairs, -1, 0);
    }

    // T.C. O(nlogn + n^2) | S.C. O(N)
    public int findLongestChainViaBottomUp(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0])); // Sorting pairs based on the first element

        int[] t = new int[n];
        Arrays.fill(t, 1);
        int maxL = 1; // assuming the longest chain is 1 so far

        for (int i = 0; i < n; i++) {
            int currIth = pairs[i][0];
            for (int j = 0; j < i; j++) {
                int jThElement = pairs[j][1];
                if (jThElement < currIth) {
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxL = Math.max(maxL, t[i]);
                }
            }
        }

        return maxL;
    }
}
