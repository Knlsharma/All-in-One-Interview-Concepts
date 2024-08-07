package DP.targetSubset;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 22/01/23, Sunday
 **/
public class canPartition {

    public boolean canPartition(int[] nums) {

        int sumOfAllEle = Arrays.stream(nums).sum();

        int result = sumOfAllEle % 2;

        if (result != 0)
        {
            return false;
        }
            result = sumOfAllEle / 2;
            return letTryPartition(nums, result);
    }

    private static boolean letTryPartition(int[] nums, int target) {

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int curr = nums[i - 1];
                        if (j >= curr) {
                            if (dp[i - 1][j - curr] == true) {
                                dp[i][j] = true;
                            } else {
                                dp[i][j] = false;
                            }
                        }
                    }
                }
            }
        }

        return dp[nums.length][target];
    }
}

//   0  1  2 3 4 5   target
//1   1  1  1 1 1 1
//
//2   0  1  2 2 3 3
//
//5              4
//
//
// 1 1 2 2 3 4