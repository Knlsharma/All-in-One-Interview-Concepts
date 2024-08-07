package Recusrion_Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 22/05/24, Wednesday
 **/

//T.C : O(2^n)
//S.C :  O(2^n*length of each subset) to store each subset
//       The recursion stack space complexity is O(N) ,
//       the maximum depth of the recursion is N, where N is the length of the input array.
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsetsWithoutDup(int[] nums) {
        List<Integer> tempResult = new ArrayList<>();
        solve(nums, 0, tempResult);
        return result;

    }

    private void solve(int[] nums, int idx, List<Integer> tempResult) {
        if (idx >= nums.length) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        tempResult.add(nums[idx]);
        solve(nums, idx + 1, tempResult); //  take
        tempResult.remove(tempResult.size() - 1);
        solve(nums, idx + 1, tempResult); // not take
    }
}
