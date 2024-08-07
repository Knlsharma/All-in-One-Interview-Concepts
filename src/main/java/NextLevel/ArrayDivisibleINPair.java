package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 27/03/22 12:35 AM
 */
public class ArrayDivisibleINPair {

    //

    public static void main(String[] args) {
        System.out.println(getPairDivisibleCount(new int[]{10, 20, 1}, 2));
    }

    private static boolean getPairDivisibleCount(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int val : arr) {
            int rem = val % k;
            if (rem < 0) {
                rem = rem + k;
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int val : arr) {
            int rem = val % k;

            // cases where it will not pass

            if (rem == 0) {      // checking from 0th if odd found
                if (map.get(rem) % 2 != 0) {
                    return false;
                }
            } else if (2 * rem == k) {      // checking from mid if odd found
                if (map.get(rem) % 2 != 0) {
                    return false;
                }
            } else {    // checking from end if odd found
                if (map.get(rem) != map.get(k - rem)) {
                    return false;
                }
            }
        }
        return true;  // Otherwise valid and pass
    }
}
