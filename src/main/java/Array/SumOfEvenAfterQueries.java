package Array;

/**
 * @author : Kunal Sharma
 * @since : 26/07/24, Friday
 **/
public class SumOfEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int sumEven = 0;
        // Calculate initial sum of even numbers
        for (int x : nums) {
            if (x % 2 == 0) {
                sumEven += x;
            }
        }

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            // Adjust the sum of even numbers based on the update
            if (nums[idx] % 2 == 0) {
                sumEven -= nums[idx];
            }

            // Update the value in nums array
            nums[idx] += val;

            // Add the new value to sumEven if it's even
            if (nums[idx] % 2 == 0) {
                sumEven += nums[idx];
            }

            // Store the result for the current query
            result[i] = sumEven;
        }

        return result;

    }
}
