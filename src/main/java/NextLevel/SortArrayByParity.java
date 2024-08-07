package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 13/08/22, Saturday
 **/
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {

        int i = 0;
        int j = 0;

        while(i < nums.length)
        {
            if(nums[i] % 2 == 1)  // odd number
            {
                i++;
            }
            else
            {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] =  temp;
                i++;
                j++;
            }
        }
        return nums;

    }
}
