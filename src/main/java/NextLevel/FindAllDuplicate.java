package NextLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 25/03/24, Monday
 **/
public class FindAllDuplicate {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        for(int num : nums) {
            int index = Math.abs(num) - 1;
            nums[index] *= -1;  // converting all to -1
        }

        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] > 0) {
                answer.add(Math.abs(num));
                nums[index] *= -1; // update index to avoid again adding back in answer
            }
        }

        return answer;

    }
}
