package BinarySearch;

/**
 * @author : Kunal Sharma
 * @since : 28/07/24, Sunday
 **/
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int right = nums.length - 1;

        int pivotIndex = getPivotIndex(nums);

        System.out.println("Pivot is " + pivotIndex);

        int leftResult = binarySearch(nums, 0, pivotIndex - 1, target);
        if (leftResult != -1) {
            return leftResult;
        }

        return binarySearch(nums, pivotIndex, right, target);
    }

    public int getPivotIndex(int[] nums) {
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
        return high;
    }

    public int binarySearch(int[] nums, int left, int right, int tar) {
        int found = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == tar) {
                found = mid;
                break;
            } else if (nums[mid] < tar) {
                left = mid + 1;
            } else if (nums[mid] > tar) {
                right = mid - 1;
            }
        }

        return found;
    }

    // below is for search rotated array 2

    public int getModifiedPivotIndexRemovingDuplicates(int[] nums) {
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
        return high;
    }
}
