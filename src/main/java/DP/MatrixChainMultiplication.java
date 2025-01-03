package DP;

/**
 * @author : Kunal Sharma
 * @since : 09/04/23, Sunday
 **/
public class MatrixChainMultiplication {

    static int matrixMultiplication(int N, int arr[]) {
        // code here
        int[][] dp = new int[arr.length - 1][arr.length - 1];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                    // bawaal
                    int min = Integer.MAX_VALUE;
                    for (int k1 = 1, k2 = g; k1 <= g; k1++, k2--) {
                        int left = dp[i][j - k2]; // arr[i] * arr[j - k2 + 1]
                        int right = dp[i + k1][j]; // arr[i + k1] * arr[ j + 1]
                        int multc = arr[i] * arr[j + 1] * arr[i + k1];

                        min = Math.min(min, left + right + multc);
                    }
                    dp[i][j] = min;
                }
            }
        }


        return dp[0][dp[0].length - 1];
    }
}
