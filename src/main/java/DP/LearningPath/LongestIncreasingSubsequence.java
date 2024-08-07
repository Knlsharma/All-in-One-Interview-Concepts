package DP.LearningPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 29/06/24, Saturday
 **/
public class LongestIncreasingSubsequence {

    private int n;
    private int[][] t;

    // T.C. = S.C = O(2^n) with recursion
    // T.C. = S.C = O(n*n) with memo
    public int lis(int[] nums, int prevIdx, int currIdx) {
        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && t[prevIdx][currIdx] != -1)
            return t[prevIdx][currIdx];

        int taken = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx])
            taken = 1 + lis(nums, currIdx, currIdx + 1);

        int notTaken = lis(nums, prevIdx, currIdx + 1);

        if (prevIdx != -1)
            t[prevIdx][currIdx] = Math.max(taken, notTaken);

        return Math.max(taken, notTaken);
    }

    public int lengthOfLIS(int[] nums) {
        t = new int[2501][2501];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        n = nums.length;
        return lis(nums, -1, 0);
    }

    // Bottom Up
    public int lengthOfLISViaBottomUp(int[] nums) {
            int n = nums.length;

            int[] t = new int[n];
            Arrays.fill(t,1);

            int maxLIS = 1;

            for(int i = 1; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(nums[j] < nums[i]) {
                        int current = t[j] + 1;
                        int initial = t[i];
                        t[i] = Math.max(initial, current);
                        maxLIS = Math.max(maxLIS, t[i]);
                    }
                }
            }

            return maxLIS;
        }

    // Patience sorting :- O(nlogn)
    public int lengthOfLIS3(int[] nums) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            /*
                Why lower bound?
                We want an increasing subsequence, and hence
                we want to eliminate the duplicates as well.
                lower_bound returns the index of "next greater or equal to."
            */
            int index = binarySearchLowerBound(sorted, nums[i]);

            if (index == sorted.size())
                sorted.add(nums[i]); // greatest: so insert it
            else
                sorted.set(index, nums[i]); // replace
        }

        return sorted.size();
    }

    private int binarySearchLowerBound(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }

}
