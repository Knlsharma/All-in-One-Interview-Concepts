package BinarySearch;

/**
 * @author : Kunal Sharma
 * @since : 28/07/24, Sunday
 **/
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean isEven = (r - mid) % 2 == 0;

            if (mid < n - 1 && nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    l = mid + 2;   // going right
                } else {
                    r = mid - 1;   // going left
                }
            } else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    r = mid - 2;  // going left
                } else {
                    l = mid + 1;  // going right
                }
            } else {
                return nums[mid];
            }
        }

        return nums[l]; // or, nums[r]

    }
}
