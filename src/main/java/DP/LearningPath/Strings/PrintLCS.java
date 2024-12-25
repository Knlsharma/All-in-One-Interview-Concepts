package DP.LearningPath.Strings;

/**
 * @author : Kunal Sharma
 * @since : 10/08/24, Saturday
 **/
public class PrintLCS {

    //Using LCS code
    //T.C : O(m*n)
    //S.C : O(m*n)
    public void printLongestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];

        // first row and first column will be 0
        for (int row = 0; row < m + 1; row++) {
            t[row][0] = 0;
        }

        for (int col = 0; col < n + 1; col++) {
            t[0][col] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();

        int i = m, j = n;

        while (i > 0 && j > 0) { // till both are common
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
                // diagonal
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;  // upward
                } else {
                    j--;  // left
                }
            }
        }

        System.out.println(lcs.reverse().toString());
    }
}
