package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 26/03/22 2:32 PM
 */
public class XofDecKLeetcode {

//    https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

    public boolean hasGroupsSizeX(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }


        int counter = 0;
        int gcd = 1;

        for (int key : map.keySet()) {
            if (counter == 0) {
                gcd = map.get(key);
            } else {
                int val = map.get(key);
                gcd = gcdCal(val, gcd);
            }
            counter++;
        }

        return gcd >= 2;
    }


    public int gcdCal(int n1, int n2) {
        while (n1 % n2 != 0) {
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;

        }
        return n2;
    }
}
