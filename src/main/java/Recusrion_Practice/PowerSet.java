package Recusrion_Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class PowerSet {

    //Approach-1 (Without For Loop)
//T.C : O(n * 2^n) - For ever index, we have two possibilities so 2^n and for copying each string to result, it takes O(n)
//S.C : O(n) - Recursion tree depth will be at max  = n  (NOTE : I have ignored space taken for storing result)
    class Solution {
        private List<String> result = new ArrayList<>();

        private void solve(StringBuilder curr, String s, int idx) {
            if (idx == s.length()) {
                if (curr.length() > 0) {
                    result.add(curr.toString()); // this taken O(N) in copy for time
                }
                return;
            }

            curr.append(s.charAt(idx));
            solve(curr, s, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
            solve(curr, s, idx + 1);
        }

        public List<String> AllPossibleStringsViaRecursion(String s) {
            StringBuilder curr = new StringBuilder();

            solve(curr, s, 0);
            Collections.sort(result);
            return result;
        }
    }


//Approach-2 (Using for loop)
//T.C : O(n * 2^n)
//S.C : O(n)
        private List<String> result = new ArrayList<>();
        private void solve(StringBuilder curr, String s, int idx) {
            if (curr.length() > 0) {
                result.add(curr.toString());
            }

            for (int i = idx; i < s.length(); i++) {
                curr.append(s.charAt(i));
                solve(curr, s, i + 1);
                curr.deleteCharAt(curr.length() - 1);
            }
        }

        public List<String> AllPossibleStringViaLoop(String s)
        {
            StringBuilder curr = new StringBuilder();

            solve(curr, s, 0);

            Collections.sort(result);

            return result;
        }
}
