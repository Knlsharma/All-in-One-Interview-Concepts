package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 03/04/22 10:39 PM
 */
public class TrickySort {

    static int sortingCost(int N, int arr[]) {

        // code here


        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;


        for (int val : arr) {

            if (map.containsKey(val - 1)) {

                map.put(val, map.get(val - 1) + 1);

            } else {

                map.put(val, 1);

            }


            if (map.get(val) > max) {

                max = map.get(val);

            }

        }


        return N - max;

    }

}
