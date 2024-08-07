package Recusrion_Practice;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 25/05/24, Saturday
 **/
public class WordBreak {

    private Boolean[] t;
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        t = new Boolean[s.length()];
        return solve(s, 0, wordDict);
    }

    private boolean solve(String s, int idx, List<String> wordDict) {
        if (idx == n) {
            return true;
        }

        if (t[idx] != null) {  // memoization
            return t[idx];
        }

        for (int endIdx = idx + 1; endIdx <= n; endIdx++) {

            String split = s.substring(idx, endIdx);

            if (wordDict.contains(split) && solve(s, endIdx, wordDict)) {
                return t[idx] = true;
            }
        }

        return t[idx] = false;
    }

}
