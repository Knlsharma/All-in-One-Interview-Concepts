package BinarySearch;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 29/07/24, Monday
 **/
public class KoKoEatBanana {
    private boolean canEatAll(int[] piles, int givenSpeed, int h) {
        int actualHours = 0;

        for (int pile : piles) {
            actualHours += pile / givenSpeed;

            if (pile % givenSpeed != 0) {
                actualHours++;
            }
        }

        return actualHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        // Binary search range
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        // Binary search to find the minimum eating speed
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (canEatAll(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
