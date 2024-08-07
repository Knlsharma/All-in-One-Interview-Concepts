package BinarySearch;

/**
 * @author : Kunal Sharma
 * @since : 28/07/24, Sunday
 **/
public class PlainBinarySearch {

    private int solve(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return solve(nums, mid + 1, r, target);
        } else {
            return solve(nums, l, mid - 1, target);
        }
    }


    public int search(int[] nums, int target) {
        int n = nums.length;
        return solve(nums, 0, n - 1, target);
    }
}
