package DP.Problems;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 29-09-2024, Sunday
 **/
public class MinimumDifficultyOfJobSchedule {

    private int[][] t;


    // Approach-1 (Recursion + Memoization)
    // T.C : O(n^2*d)
    // S.C : O(301*11) ~= O(1)
    public int minDifficulty1(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        t = new int[n][d + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(jobDifficulty, n, 0, d);
    }

    private int solve(int[] jobDifficulty, int n, int idx, int d) {
        // If you have only 1 day, then you will do all the remaining jobs
        // and select the max difficulty as the answer
        if (d == 1) {
            return Arrays.stream(Arrays.copyOfRange(jobDifficulty, idx, n)).max().orElse(Integer.MIN_VALUE);
        }

        if (t[idx][d] != -1)
            return t[idx][d];

        int maxDifficulty = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        // Try one by one with all possibilities
        /*
         * Take 1 job in one day Take 2 jobs in one day Take 3 jobs in one day and so
         * on Then find the optimal one among all the results
         */
        for (int i = idx; i <= n - d; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);
            result = Math.min(result, maxDifficulty + solve(jobDifficulty, n, i + 1, d - 1));
        }

        return t[idx][d] = result;
    }


    // Approach - 2 (Bottom UP)
    // T.C : O(n^2 * d)
    // S.C : O(n*d)
    public int minDifficulty2(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        int[][] t = new int[n + 1][d + 1];

        // Base case: if there is only one day - Do all jobs on that day
        for (int i = 0; i < n; i++) {
            t[i][1] = Arrays.stream(Arrays.copyOfRange(jobDifficulty, i, n)).max().orElse(Integer.MIN_VALUE);
        }

        // Build the DP table bottom-up
        for (int days = 2; days <= d; days++) {
            for (int i = 0; i <= n - days; i++) {
                int maxDifficulty = Integer.MIN_VALUE;
                int result = Integer.MAX_VALUE;

                for (int j = i; j <= n - days; j++) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]);
                    result = Math.min(result, maxDifficulty + t[j + 1][days - 1]);
                }

                t[i][days] = result;
            }
        }

        return t[0][d];

    }

}
