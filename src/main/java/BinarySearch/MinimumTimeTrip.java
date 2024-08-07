package BinarySearch;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 29/07/24, Monday
 **/
public class MinimumTimeTrip {

    private boolean possible(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;

        for (int t : time) {
            actualTrips += givenTime / t;
        }

        return actualTrips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;

        // Binary search range
        long l = 1;
        long r = (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        // Binary search to find the minimum time
        while (l < r) {
            long midTime = l + (r - l) / 2;

            if (possible(time, midTime, totalTrips)) {
                r = midTime;
            } else {
                l = midTime + 1;
            }
        }

        return l;
    }
}
