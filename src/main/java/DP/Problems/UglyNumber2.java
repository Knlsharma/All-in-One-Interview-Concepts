package DP.Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 05-10-2024, Saturday
 **/
public class UglyNumber2 {


    private Map<Integer, Boolean> mp = new HashMap<>();


    // Approach-1 (Recursion+Memo)
    // T.C : O(n * log k), where k is the number range to find the nth ugly number.
    // S.C : O(u), where U is the number of distinct values stored in the memoization map mp.
    public int nthUglyNumberUsingRecur(int n) {
        mp.clear();
        int num = 1;
        while (n > 0) {
            if (isUgly(num)) {
                n--;
            }
            num++;
        }

        return num - 1;
    }

    private boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        if (mp.containsKey(n)) {
            return mp.get(n);
        }

        if (n % 2 == 0 && isUgly(n / 2)) {
            mp.put(n, true);
            return true;
        } else if (n % 3 == 0 && isUgly(n / 3)) {
            mp.put(n, true);
            return true;
        } else if (n % 5 == 0 && isUgly(n / 5)) {
            mp.put(n, true);
            return true;
        }

        mp.put(n, false);
        return false;
    }


    // Bottom UP
    // T.C : O(n))
    // S.C : O(n)
    public int nthUglyNumber(int n) {

        int[] t = new int[n + 1];
        // t[i] = ith Ugly number;
        // we will return t[n] = nth ugly number

        t[1] = 1; // 1st Ugly number

        int i2 = 1; // i2th Ugly number
        int i3 = 1; // i3rd Ugly number
        int i5 = 1; // i5th Ugly number

        for (int i = 2; i <= n; i++) {
            int i2th_ugly = t[i2] * 2;
            int i3rd_ugly = t[i3] * 3;
            int i5th_ugly = t[i5] * 5;

            t[i] = Math.min(Math.min(i2th_ugly, i3rd_ugly), i5th_ugly);

            if (t[i] == i2th_ugly) {
                i2++;
            }

            if (t[i] == i3rd_ugly) {
                i3++;
            }

            if (t[i] == i5th_ugly) {
                i5++;
            }
        }

        return t[n];
    }
}
