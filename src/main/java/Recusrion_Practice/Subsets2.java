package Recusrion_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 26/05/24, Sunday
 **/
//TC :- O(nlogn + 2^n)
// SC :- O(n)
public class Subsets2 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort the array to handle duplicates
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int idx, List<Integer> temp) {
        // Add the current subset to the result
        result.add(new ArrayList<>(temp));

        for (int i = idx; i < nums.length; i++) {
            // Skip duplicates
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            // Include the current element
            temp.add(nums[i]);
            // Move to the next element
            solve(nums, i + 1, temp);
            // Exclude the current element (backtrack)
            temp.remove(temp.size() - 1);
        }
    }
}
