package DP.LearningPath;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 28/06/24, Friday
 **/
// T.C. = O(N*2) --> O(N
public class AlternatingSum {

    private int n;
    private long[][] t;

    private long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) {
            return 0;
        }
        if (t[idx][isEven ? 1 : 0] != -1) {
            return t[idx][isEven ? 1 : 0];
        }

        long skip = solve(idx + 1, nums, isEven);

        long val = nums[idx];
        if (!isEven) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !isEven) + val;

        return t[idx][isEven ? 1 : 0] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n][2];
//        for (int i = 0; i < n; i++) {
//            t[i][0] = -1;
//            t[i][1] = -1;
//        }
        for (long[] array : t) {
            Arrays.fill(array, -1);
        }
        return solve(0, nums, true);
    }

    // approach 2
    public long maxAlternatingSumViaBottomUp(int[] nums) {
        int n = nums.length;

        long[][] t = new long[n][2];

        t[0][0] = Math.max(-nums[0], 0);
        t[0][1] = Math.max(nums[0], 0);

        for (int i = 1; i < n; i++) {
            long takeEven = t[i-1][1] - nums[i]; // odd length - even length
            long skipCaseEven = t[i-1][0];
            t[i][0] = Math.max(takeEven, skipCaseEven);
            long takeOdd =t[i-1][0] + nums[i] ; // even length + odd length
            long skipCaseOdd = t[i-1][1];
            t[i][1] = Math.max(takeOdd, skipCaseOdd);
        }

        return Math.max(t[n-1][0], t[n-1][1]);
    }

    // space optimised
    public long maxAlternatingSumSpaceOptimized(int[] nums) {
        int n = nums.length;

        int prevPrev = 0;
        int prev     = nums[0];

        for(int i = 2; i<=n; i++) {
            int skip = prev;

            int take = nums[i-1] + prevPrev;

            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev     = temp;
        }

        return prev;
    }
}
