package Array;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class FindMissingAndDuplicate {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int dupIndex = -1;
        int missingVal = -1;

        // finding duplicate index
        for (int currIdx = 0; currIdx < n; currIdx++) {
            int num = Math.abs(nums[currIdx]);

            if (nums[num - 1] < 0)
                dupIndex = num;
            else
                nums[num - 1] *= (-1);
        }

        // finding missing
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missingVal = i + 1;
                break;
            }
        }

        return new int[]{dupIndex, missingVal};
    }
}
