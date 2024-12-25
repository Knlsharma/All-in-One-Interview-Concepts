package DP.LearningPath;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 13/08/24, Tuesday
 **/
public class ShortestSubsequence {

    int[][] t;

    // T.C : O(m*n)
    // S.C : O(m*n)
    public int solve(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return m + n;
        }

        if (t[m][n] != -1) {
            return t[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return t[m][n] = 1 + solve(s1, s2, m - 1, n - 1);
        } else {
            return t[m][n] = 1 + Math.min(solve(s1, s2, m - 1, n), solve(s1, s2, m, n - 1));
        }
    }

    // Function to find length of shortest common supersequence of two strings.
    public int shortestCommonSupersequence(String s1, String s2, int m, int n) {
        t = new int[m + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, m, n);
    }

    // approach 2

    // T.C : O(m*n)
    // S.C : O(m*n)
    public int shortestCommonSupersequenceUsingTwo(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        populateShortestCommonSequence(s1, s2, m, n, t);

        return t[m][n];
    }

    private static void populateShortestCommonSequence(String s1, String s2, int m, int n, int[][] t) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = i + j;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
    }

    //approach 3 :- Using LCS

    public int shortestCommonSupersequenceUsingLCS(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        prepareLCS(s1, s2, m, n, t);

        int LCS = t[m][n];

        int letters_from_s1 = m - LCS;
        int letters_from_s2 = n - LCS;

        return LCS + letters_from_s1 + letters_from_s2;
        // LCS + m - LCS + n - LCS =>  M + N - LCS
    }

    private static void prepareLCS(String s1, String s2, int m, int n, int[][] t) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
    }

    // Print Shortest supersequence

    // T.C = S.C = O(m*n)
    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];

        populateShortestCommonSequence(s1, s2, m, n, t);

        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
                // moving diagonal
            } else {
                if (t[i - 1][j] < t[i][j - 1]) {
                    result.append(s1.charAt(i - 1));  // take char from last for ith
                    i--; // current row discarded
                    // moving upward
                } else {
                    result.append(s2.charAt(j - 1));  // take char from last for jth
                    j--; // current col discarded
                    // moving leftward
                }
            }
        }

        // add remaining characters from both s1 and s2

        while (i > 0) {
            result.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(s2.charAt(j - 1));
            j--;
        }
        return result.reverse().toString();

    }


}


