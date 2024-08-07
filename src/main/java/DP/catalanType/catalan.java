package DP.catalanType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 08/01/23, Sunday
 **/

public class catalan {

    public List<String> generateParenthesis(int n) { // 
        List<String>[] dp = new List[n + 1];
        dp[0] = Arrays.asList("");
        dp[1] = Arrays.asList("()");

        for (int i = 2; i <= n; i++) {
            dp[i] = new ArrayList<>();
            int inner = i - 1;
            int outer = 0;
            while (inner >= 0 && outer <= i - 1) {
                for (String in : dp[inner]) {
                    for (String out : dp[outer]) {
                        StringBuilder sb = new StringBuilder()
                                .append("(")
                                .append(in)
                                .append(")")
                                .append(out);
                        dp[i].add(sb.toString());
                    }

                }

                inner--;
                outer++;

            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        catalan(10);
    }

    public static void catalan(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = i - 1;
            while (left <= i - 1) {
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}


// c1 = 1

// c0 = 1

// c2 = c0*c1 + c1*c0 = 2

// c3 = c0*c2 + c2*c0 + c1*c1 = 2 + 2  + 1 = 5

// ()()(), () (()), (())(), (()()), ((()))

// c4 = c0*c3 + c1*c2 + c2*c1 + c3*c0 = 1 * 5 + 1 * 2 + 1 * 2 + 5 * 1 = 14