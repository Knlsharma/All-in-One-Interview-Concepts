package BinarySearch;

/**
 * @author : Kunal Sharma
 * @since : 28/07/24, Sunday
 **/
public class PivotIndex {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    public int findPivotElementWithDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            while (low < high && nums[low] == nums[low + 1]) { // skipping from left side
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) { // skipping from right side
                high--;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[high];
    }

}
