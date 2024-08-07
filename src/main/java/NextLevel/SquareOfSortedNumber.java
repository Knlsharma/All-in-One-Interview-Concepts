package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 16/07/22, Saturday
 **/
public class SquareOfSortedNumber {

    public int[] sortedSquares(int[] nums) {

        int l = 0 ;
        int r = nums.length - 1;

        int[] result = new int[nums.length];
        int k = r;

        while(k >= 0)
        {
            if((nums[l]*nums[l]) < (nums[r]*nums[r]))
            {
                result[k] = nums[r]*nums[r];
                r--;
            }
            else
            {
                result[k] = nums[l]*nums[l];
                l++;
            }
            k--;
        }

        return result;

    }

    // public static void swap(nums, int li , int ri)
    // {
    //    int temp = nums[li];
    //     nums[li] = nums[ri];
    //     nums[ri] = temp;
    // }
}

