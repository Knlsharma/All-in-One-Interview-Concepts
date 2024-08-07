package DP;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 02/01/23, Monday
 **/
public class LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {
        int len = 1;

        int[] tails = new int[nums.length];
        tails[0] = nums[0];


        for(int i = 0; i < nums.length; i++){
            if(nums[i] > tails[len - 1]){
                len++;
                tails[len - 1] = nums[i];
            } else {
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);

                if(idx < 0){
                    idx = -idx;
                    idx = idx - 1;
                }

                tails[idx] = nums[i];
            }
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {-1,-4,-3,-2,-9,-7}));
    }
}
