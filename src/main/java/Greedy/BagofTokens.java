package Greedy;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/

//T.C. : O(NlogN)
//S.C. : O(1)
public class BagofTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        Arrays.sort(tokens);

        int currScore = 0;
        int maxScore = 0;
        int l = 0, r = n - 1;

        // GREEDY
        // While losing power, I will choose the smallest token
        // While gaining power, I will choose the largest token

        while (l <= r) {
            if (P >= tokens[l]) {
                currScore++;
                maxScore = Math.max(maxScore, currScore); // keep updating it
                P -= tokens[l]; // choose smallest token
                l++;

            } else if (currScore >= 1) {
                currScore--;
                P += tokens[r]; // choose largest token
                r--;

            } else {
                // no way further to increase score
                return maxScore;
            }
        }
        return maxScore;

    }
}
