package DP.LearningPath.Strings.Pallindromic;

/**
 * @author : Kunal Sharma
 * @since : 11/08/24, Sunday
 **/
public class LongestPalindromicSubString {

    //Approach 3 - Using Bottom Up (Elaborated for simplicity)
    //T.C : O(n^2)
    //S.C : O(n^2)
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 0;
        int index = 0;

        boolean[][] t = new boolean[n][n];

        // Every single character is a palindrome
        for (int L = 0; L < n; L++) {
            t[L][L] = true;
            maxL = 1;
            index = L;
        }

        // Check for palindromes of length 2
        for (int L = 0; L < n - 1; L++) {
            if (s.charAt(L) == s.charAt(L + 1)) {
                t[L][L + 1] = true;
                maxL = 2;
                index = L;
            }
        }

        // Check for palindromes of length 3 or more
        for (int L = 3; L <= n; L++) {
            int window = n - L + 1;
            for (int i = 0; i < window; i++) { //  or i + L - 1 < n
                int windowEnd = i + L - 1;

                if (s.charAt(i) == s.charAt(windowEnd) && t[i + 1][windowEnd - 1]) {
                    t[i][windowEnd] = true;
                    if (windowEnd - i + 1 > maxL) {
                        maxL = windowEnd - i + 1;
                        index = i;
                    }
                }
            }
        }

        return s.substring(index, index + maxL);
    }

    //Simplified solution
    // T.C = S.C is same
    public String longestPalindromeSimplifiedAbove(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        int maxL = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;

                if (s.charAt(i) == s.charAt(j) && (t[i + 1][j - 1] || L == 2)) {
                    t[i][j] = true;
                    if (L > maxL) {
                        maxL = L;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxL);
    }
}
