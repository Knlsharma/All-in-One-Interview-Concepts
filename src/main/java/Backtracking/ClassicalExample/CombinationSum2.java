package Backtracking.ClassicalExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class CombinationSum2 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort to handle duplicates
        Arrays.sort(candidates);
        // Start the recursive search
        solve(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void solve(int[] candidates, int start, int target, List<Integer> tempList) {
        // Base Case: Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(tempList)); // creating new list to avoid changes to new list
            return;
        }
        // Base Case: Exceeded the target
        if (target < 0) {
            return;
        }

        for (int currentIndex = start; currentIndex < candidates.length; currentIndex++) {
            // Skip duplicates
            if (currentIndex > start && candidates[currentIndex] == candidates[currentIndex - 1]) {
                continue;
            }

            // Include the current candidate
            tempList.add(candidates[currentIndex]);
            // Recur with updated target and index
            solve(candidates, currentIndex + 1, target - candidates[currentIndex], tempList);
            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}
