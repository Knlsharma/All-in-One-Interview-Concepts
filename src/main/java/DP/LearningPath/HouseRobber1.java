package DP.LearningPath;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 28/06/24, Friday
 **/
public class HouseRobber1 {



    /*
    Using recursion
    */

    int[] t;

    public int solve(int[] nums, int i, int n) {
        if (i >= n)
            return 0;

        if (t[i] != -1)
            return t[i];

        int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

        t[i] = Math.max(take, skip);
        return t[i];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        t = new int[n];
        Arrays.fill(t, -1);
        return solve(nums, 0, n);
    }

    /*
    Optimised using constant space
     */
    int robUsingConstantSpace(int[] nums) {
        int n = nums.length;

        int prevPrev = 0;
        int prev = nums[0];

        for (int i = 2; i <= n; i++) {
            int skip = prev;

            int take = nums[i - 1] + prevPrev;

            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }




}
