package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 20/08/22, Saturday
 **/
public class PartitionDisjoints {

    public int partitionDisjoint(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left[i] = nums[i];
            } else {
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }

        for(int i = nums.length - 1; i >= 0; i--){
            if(i == nums.length - 1){
                right[i] = nums[i];
            } else {
                right[i] = Math.min(nums[i], right[i + 1]);
            }
        }

        int ans = -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(left[i] <= right[i + 1]){
                ans = i + 1;
                break;
            }
        }

        return ans;

    }
}
