package NextLevel;

/**
 * @author : Kunal Sharma
 * @since : 14/08/22, Sunday
 **/
public class FirstMissingPositiveNumber {

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n + 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);

            if(val <= n){
                int idx = val - 1;

                if(nums[idx] > 0){
                    nums[idx] = -1 * nums[idx];
                }
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return n + 1;

    }

    public int firstMissingPositive2(int[] nums) {

        int n = nums.length;
        boolean[] exists = new boolean[n];
        for (int num : nums) {
            if (num > 0 && num <= n) exists[num - 1] = true;
        }
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) return i + 1;
        }
        return n + 1;
    }
}
