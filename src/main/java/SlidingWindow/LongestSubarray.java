package SlidingWindow;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int zeroCount = 0; // Count of zeros in the current window
        int longestWindow = 0; // Length of the longest valid window
        int start = 0; // Left boundary of the sliding window

        // Iterate through the array with the end boundary
        for (int end = 0; end < nums.length; end++) {
            // Increase zero count if the current element is zero
            if (nums[end] == 0) {
                zeroCount++;
            }

            // Shrink the window until the number of zeros is within the limit
            while (zeroCount > 1) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++; // Move the left boundary of the window to the right
            }

            // Update the length of the longest valid window
            longestWindow = Math.max(longestWindow, end - start);
        }

        return longestWindow; // Return the length of the longest valid window
    }


    public int longestSubarrayBetterWay(int[] nums) {
        int start = 0;            // Left boundary of the sliding window
        int end = 0;              // Right boundary of the sliding window

        int lastZeroIndex = -1;   // Position of the last zero encountered
        int maxLength = 0;        // Length of the longest valid subarray

        while (end < nums.length) {
            if (nums[end] == 0) {
                start = lastZeroIndex + 1; // Move start to the position after the last zero
                lastZeroIndex = end;       // Update the last zero index
            }

            // Calculate the length of the current valid window
            maxLength = Math.max(maxLength, end - start);
            end++; // Expand the window to the right
        }

        return maxLength;  // Return the maximum length of the valid subarray

    }

}
