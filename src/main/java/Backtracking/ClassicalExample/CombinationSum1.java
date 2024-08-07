package Backtracking.ClassicalExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 05/08/24, Monday
 **/
public class CombinationSum1 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void solve(int[] candidates, int target,
                       int start, List<Integer> curr) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || start >= candidates.length) {
            return;
        }

        // Include the current candidate
        curr.add(candidates[start]);
        solve(candidates, target - candidates[start], start, curr);
        curr.remove(curr.size() - 1);

        // Exclude the current candidate
        solve(candidates, target, start + 1, curr);
    }

    // approach using for loop
    private void solveUsingForLoop(int[] candidates, int target, int currentIndex, List<Integer> templList) {
        if (target == 0) {
            result.add(new ArrayList<>(templList));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int index = currentIndex; index < candidates.length; index++) {
            templList.add(candidates[index]);
            solveUsingForLoop(candidates, target - candidates[index], index, templList);
            templList.remove(templList.size() - 1);
            // automatically index will be incremented
        }
    }
}
