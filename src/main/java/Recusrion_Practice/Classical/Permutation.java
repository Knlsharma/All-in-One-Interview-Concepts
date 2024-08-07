package Recusrion_Practice.Classical;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class Permutation {


//  time complexity is O(n×n!)
//  space complexity is O(n×n!)

    // Approach 1 :- Swapping
    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute1(int[] nums) {
        n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        solve(0, numList);

        return result;
    }

    private void solve(int idx, List<Integer> nums) {
        if (idx == n) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(nums, i, idx);
            solve(idx + 1, nums);
            swap(nums, i, idx);
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }


    // approach 2 :- Backtracking
    //  time complexity is O(n×n!)
    //  space complexity is O(n×n!)

    List<List<Integer>> result2 = new ArrayList<>();
    Set<Integer> st = new HashSet<>(); // to avoid duplicates
    int n2;

    public List<List<Integer>> permute2(int[] nums) {
        n2 = nums.length;
        List<Integer> temp = new ArrayList<>();

        solve2(temp, nums);

        return result2;
    }

    private void solve2(List<Integer> temp, int[] nums) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!st.contains(nums[i])) {
                temp.add(nums[i]);
                st.add(nums[i]);

                solve2(temp, nums);

                st.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
