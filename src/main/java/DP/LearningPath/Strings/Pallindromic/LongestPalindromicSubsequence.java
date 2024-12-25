package DP.LearningPath.Strings.Pallindromic;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 12/08/24, Monday
 **/
public class LongestPalindromicSubsequence {

    int[][] t = new int[1001][1001];
    //Approach-1 (Recursion + Memoization)
    //T.C : O(m*n)
    //S.C : O(m*n)
    public int LPS(String s, int i, int j) {
        if (i > j)
            return 0;
        if (i == j) // both met
            return 1;

        if (t[i][j] != -1)
            return t[i][j];
        if (s.charAt(i) == s.charAt(j))
            return t[i][j] = 2 + LPS(s, i + 1, j - 1);
        else
            return t[i][j] = Math.max(LPS(s, i + 1, j), LPS(s, i, j - 1));
    }

    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return LPS(s, 0, m - 1); // Approach-1
    }


    // Approach-2 (Recursion + Memoization) But using LCS
    public int LCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return t[m][n] = 0;

        if (t[m][n] != -1)
            return t[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return t[m][n] = 1 + LCS(s1, s2, m - 1, n - 1);

        return t[m][n] = Math.max(LCS(s1, s2, m, n - 1), LCS(s1, s2, m - 1, n));
    }

    public int UsingLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        t = new int[m + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return LCS(text1, text2, m, n);
    }

    public int longestPalindromeSubseqUsingLCS(String s) {
        String n = new StringBuilder(s).reverse().toString();
        return UsingLCS(s, n);
    }

    // approach -3
    // Using LCS bottom up

    public int longestPalindromeSubseqUsingLCSBottomUp(String s) {
        String n = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequenceBottomUp(s, n);
    }

    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        return t[m][n];
    }

    // approach - 4
    // Pure bottom up or blueprint
    //T.C : O(n*n)
    //S.C : O(n*n)
    public int longestPalindromeSubseqUsingBottomUp(String s) {
        int n = s.length();

        int[][] t = new int[n][n];
        // t[i][j] = longest common subsequence in string from i to j indices;
        // strings of length 1 are always a palindrome
        for (int i = 0; i < n; i++) {
            t[i][i] = 1; //  diagonal elements of length 1
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int windowEnd = i + L - 1;

                if (s.charAt(i) == s.charAt(windowEnd) && L == 2)
                    t[i][windowEnd] = 2;  //  double length is a palindrome
                else if (s.charAt(i) == s.charAt(windowEnd)) {
                    t[i][windowEnd] = 2 + t[i + 1][windowEnd - 1];
                } else {
                    t[i][windowEnd] = Math.max(t[i + 1][windowEnd], t[i][windowEnd - 1]);
                }
            }
        }
        return t[0][n - 1];
    }


}
