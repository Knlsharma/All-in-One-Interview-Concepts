package SlidingWindow;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class MaximumConsecutiveOnes3 {

    public int longestOnes(int[] nums, int k) {

        int maximumCount = 0;
        int end = 0;
        int start = 0;

        int countZero = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                countZero++;
            }
            while (countZero > k) {
                if (nums[start] == 0) {
                    countZero--;
                }
                start++;              // release in case of invalid
            }
            end++;   // acquire

            //check for maximum one's
            int windowSize = end - start + 1;
            maximumCount = Math.max(maximumCount, windowSize);
        }
        return maximumCount - 1;
    }
}
