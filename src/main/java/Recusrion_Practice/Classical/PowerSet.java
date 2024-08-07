package Recusrion_Practice.Classical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 16/06/24, Sunday
 **/
public class PowerSet {


    //Approach 1
    //T.C : O(n * 2^n) - For ever index, we have two possibilities so 2^n and for copying each string to result, it takes O(n)
    //S.C : O(n) - Recursion tree depth will be at max  = n  (NOTE : I have ignored space taken for storing result)
    private List<String> result = new ArrayList<>();

    private void solve(StringBuilder curr, String s, int idx) {
        if (idx == s.length()) {
            if (curr.length() > 0) {
                result.add(curr.toString());
            }
            return;
        }

        curr.append(s.charAt(idx));
        solve(curr, s, idx + 1);
        curr.deleteCharAt(curr.length() - 1);
        solve(curr, s, idx + 1);
    }

    public List<String> AllPossibleStrings(String s) {
        StringBuilder curr = new StringBuilder();

        solve(curr, s, 0);

        Collections.sort(result);

        return result;
    }

    //Approach - 2 (Using for loop)

    public List<String> AllPossibleStrings2(String s)
    {
        StringBuilder curr = new StringBuilder();

        solve2(curr, s, 0);

        Collections.sort(result);

        return result;
    }

    private void solve2(StringBuilder curr, String s, int idx) {
        if (curr.length() > 0) {
            result.add(curr.toString());
        }

        for (int i = idx; i < s.length(); i++) {
            curr.append(s.charAt(i));
            solve2(curr, s, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
