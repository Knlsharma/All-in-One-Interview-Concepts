package DP.LearningPath.Strings.Pallindromic;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 11/08/24, Sunday
 **/
public class PalindromicSubString {

    int[][] t;

    //approach 1
    public boolean check(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (t[i][j] != -1) {
            return t[i][j] == 1;
        }

        if (s.charAt(i) == s.charAt(j)) {
            boolean val = check(s, i + 1, j - 1);
            if (val == true)
                t[i][j] = 1;
            else
                t[i][j] = 0;
            return val;
        }

        t[i][j] = 0;
        return false;
    }

    // T.C : O(n^2) - Every subproblem is being computed only once and after that, it's being reused
    // S.C : O(n^2)
    public int countSubstrings(String s) {
        int n = s.length();
        t = new int[n][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // check all possible substrings
                if (check(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    // approach 2
    // T.C : O(n^2)
    // S.C : O(n^2)
    public int countSubstringsBottomUp(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];

        int count = 0;

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    t[i][i] = true; // Single characters are palindrome
                } else if (i + 1 == j) {
                    t[i][j] = (s.charAt(i) == s.charAt(j)); // Strings of 2 Length
                } else {
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]);
                }

                if (t[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach-4 (Smart approach)
    // T.C : O(n^2)
    // S.C : O(1)

    private int count = 0;

    private void check(String s, int i, int j, int n) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            count++;
            i--; // expanding from center
            j++; // expanding from center
        }
    }

    public int countSubstringsSmartApproach(String s) {
        int n = s.length();
        count = 0;

        /*
         * Every single character in the string is a center for possible odd-length
         * palindromes: check(s, i, i);
         *
         *  Every pair of consecutive characters in the
         * string is a center for possible even-length palindromes: check(s, i, i+1);
         */
        for (int i = 0; i < n; i++) {
            check(s, i, i, n);  // odd-length
            check(s, i, i + 1, n); // even-length
        }
        return count;
    }
}
