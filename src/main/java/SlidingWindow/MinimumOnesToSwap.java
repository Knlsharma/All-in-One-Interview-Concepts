package SlidingWindow;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class MinimumOnesToSwap {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] temp = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            temp[i] = nums[i % n];
        }

        int countOnes = Arrays.stream(nums).sum();

        int i = 0;
        int end = 0;
        int currCount = 0;
        int maxCount = 0;

        while (end < 2 * n) {

            if (temp[end] == 1) {
                currCount++;    //  acquire
            }

            int currentWindowSize = end - i + 1;
            if (currentWindowSize > countOnes) {
                currCount -= temp[i];
                i++;  // release
            }

            maxCount = Math.max(maxCount, currCount);
            end++;
        }

        return countOnes - maxCount;
    }

    public int minSwapsSecondWay(int[] nums) {
        int n = nums.length;

        int countOnes = Arrays.stream(nums).sum();

        int start = 0;
        int end = 0;
        int currCount = 0;
        int maxCount = 0;

        while (end < 2 * n) {
            if (nums[end % n] == 1) {
                currCount++;  // acquire
            }

            int windowSize = end - start + 1;
            if (windowSize > countOnes) {
                currCount -= nums[start % n];
                start++;     // release
            }

            maxCount = Math.max(maxCount, currCount);
            end++;
        }

        return countOnes - maxCount;
    }
}
