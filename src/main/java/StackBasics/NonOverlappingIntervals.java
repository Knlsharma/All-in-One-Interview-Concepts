package StackBasics;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 01/01/24, Monday
 **/
public class NonOverlappingIntervals {


    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int previous = 0;
        int n = intervals.length;
        for (int current = 1; current < n; current++) {
            if (intervals[current][0] < intervals[previous][1]) {
                ans++;
                if (intervals[current][1] <= intervals[previous][1]) {
                    previous = current;
                }
            } else {
                previous = current;
            }
        }
        return ans;
    }
}


