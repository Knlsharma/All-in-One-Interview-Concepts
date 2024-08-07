package DP.LearningPath;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Kunal Sharma
 * @since : 30/06/24, Sunday
 **/
public class LongestStringChain {

    int n;
    int[][] t = new int[1001][1001];

    int lis(String[] words, int prevIdx, int currIdx) {
        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && t[prevIdx][currIdx] != -1)
            return t[prevIdx][currIdx];

        int taken = 0;
        if (prevIdx == -1 || isPredecessor(words[prevIdx], words[currIdx]))
            taken = 1 + lis(words, currIdx, currIdx + 1);

        int notTaken = lis(words, prevIdx, currIdx + 1);

        if (prevIdx != -1)
            t[prevIdx][currIdx] = Math.max(taken, notTaken);

        return Math.max(taken, notTaken);
    }

    //T.C : O(nlogn + 2^n⋅L) | S.C. : O(n) : Without Memoization
    //T.C : O(nlogn + n^2⋅L) | S.C. : O(n^2) : With Memoization
    int longestStrChain(String[] words) {
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                t[i][j] = -1;
            }
        }

        n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length)); // You can select pairs in any order.
        return lis(words, -1, 0);
    }

    // where L is the maximum length of the either words :- O(L)
    public boolean isPredecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        if (M >= N || N - M != 1)
            return false;

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }

    // T.C. O(nlogn + n^2⋅L) | S.C. O(N)
    public int longestStrChainViaBottomUp(String[] words) {
        int n = words.length;
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        int[] t = new int[n];
        Arrays.fill(t, 1);   // assuming each of max length
        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (isPredecessor(words[j], words[i])) {
                    int newLen = t[j] + 1;
                    int currentLen = t[i];
                    t[i] = Math.max(currentLen, newLen);
                    maxL = Math.max(maxL, t[i]);
                }
            }
        }
        return maxL;
    }
}
