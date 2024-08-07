package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 16/04/22 11:06 AM
 */
public class HouseOfRobber {

    static int[] arr = new int[]{9, 20, 11, 8};
    static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // start from zeroth house
        System.out.println(getMaxHouseRobb(0));
        System.out.println(map);
    }

    private static int getMaxHouseRobb(int i) {

        if (i >= arr.length) {
            // invalid house to robb
            return 0;
        } else {
            // acquired house and move to next house OR if skip move to next House
            if(map.containsKey(i))
            {
                return map.get(i);
            }
            int calculatedVal = Math.max(arr[i] + getMaxHouseRobb(i + 2), getMaxHouseRobb(i + 1));
            map.put(i,calculatedVal);
            return calculatedVal;
        }
    }
}
