package DP.LearningPath;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 28/06/24, Friday
 **/

// T.C. = S.C. = O(N)
public class HouseRobber2 {

        // 1st approach
        int[] t = new int[101];

        public int solve(int[] nums, int i, int n) {
            if (i > n)
                return 0;

            if (t[i] != -1)
                return t[i];

            int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal adjacent)
            int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

            return t[i] = Math.max(take, skip);
        }

        public int rob(int[] nums) {
            int n = nums.length;

            if (n == 1)
                return nums[0];

            if (n == 2)
                return Math.max(nums[0], nums[1]);

            Arrays.fill(t, -1);

            // case-1 - Take first house 0th index wala house
            System.out.println("Case1: start: 0 end: " + (n - 2));
            int take_0th_index_house = solve(nums, 0, n - 2);
            System.out.println("Case1: op " + take_0th_index_house);

            Arrays.fill(t, -1);

            // case-2 - Take second house 1st index wala house
            System.out.println("Case2: start: 1 end: " + (n - 1));
            int take_1st_index_house = solve(nums, 1, n - 1);
            System.out.println("Case2: op " + take_1st_index_house);

            return Math.max(take_0th_index_house, take_1st_index_house);
        }


        // 2nd approach

    public int bottomUp(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int[] t = new int[n + 1];
        // t[i] = Max money gained from i houses

        int takeFrom1stHouse = 0;
        int takeFrom2ndHouse = 0;

        // Case-1 (Take from 1st House - Hence skip the last house)
        t[0] = 0;
        for (int i = 1; i <= n - 1; i++) {
            int currentSkip = t[i - 1];
            int currentTake  = nums[i - 1] + ((i - 2 >= 0) ? t[i - 2] : 0);
            t[i] = Math.max(currentSkip, currentTake);
        }
        takeFrom1stHouse = t[n - 1];

        // Reset the array
        Arrays.fill(t, 0);

        // Case-2 (Take from 2nd House - Hence take the last house)
        t[0] = 0;
        t[1] = 0;
        for (int i = 2; i <= n; i++) {
            int currentSkip = t[i - 1];
            int currentTake = nums[i - 1] + ((i - 2 >= 0) ? t[i - 2] : 0);
            t[i] = Math.max(currentSkip, currentTake);
        }
        takeFrom2ndHouse = t[n];

        return Math.max(takeFrom1stHouse, takeFrom2ndHouse);
    }




    // 3rd approach
    public int solveViaConstantSpace(int[] nums, int l, int r) {
        int prevPrev = 0, prev = 0;

        for (int i = l; i <= r; i++) {
            int skip = prev;
            int take = nums[i] + prevPrev;

            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }

    public int robViaConstantSpace(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int takeFirstHouse = solveViaConstantSpace(nums, 0, n - 2);
        int skipFirstHouse = solveViaConstantSpace(nums, 1, n - 1);

        return Math.max(takeFirstHouse, skipFirstHouse);
    }


    }
