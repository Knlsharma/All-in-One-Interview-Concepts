package Backtracking.ClassicalExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 07/08/24, Wednesday
 **/
public class CombinationSum3 {

    private List<List<Integer>> result = new ArrayList<>();
    private int end = 9; // Numbers are from 1 to 9

    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1, new ArrayList<>(), k, n); // Start from number 1
        return result;
    }

    private void solve(int start, List<Integer> tempList, int quantity, int target) {
        if (target == 0 && tempList.size() == quantity) {
            result.add(new ArrayList<>(tempList)); // Create a copy of tempList to add to result
            return;
        }
        if (target < 0 || tempList.size() > quantity) {
            return; // Stop recursion if target is exceeded or tempList size exceeds quantity
        }

        for (int index = start; index <= end; index++) {
            tempList.add(index); // Choose the current number
            solve(index + 1, tempList, quantity, target - index); // Recur with updated target
            tempList.remove(tempList.size() - 1); // Backtrack, remove the last number
        }
    }

}
