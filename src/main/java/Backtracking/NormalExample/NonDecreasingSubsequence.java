package Backtracking.NormalExample;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author : Kunal Sharma
 * @since : 26/05/24, Sunday
 **/
// TC : O(2^n) either choose or not
// SC : O(n) as loop running in worst case
public class NonDecreasingSubsequence {

    int n;

    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void backtrack(int[] nums, int idx, LinkedList<Integer> curr, List<List<Integer>> result) {
        if (curr.size() > 1)
            result.add(new LinkedList<Integer>(curr));

        Set<Integer> used = new HashSet<>();

        for (int i = idx; i < n; i++) {

            if ((curr.size() == 0 || nums[i] >= curr.peekLast()) && !used.contains(nums[i])) {
                used.add(nums[i]);

                curr.add(nums[i]);

                backtrack(nums, i + 1, curr, result);

                curr.remove(curr.size() - 1);
            }
        }
    }
}
