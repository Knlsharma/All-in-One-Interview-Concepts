package HashMap;

import java.util.HashMap;

/**
 * @author : Kunal Sharma
 * @since : 28/05/23, Sunday
 **/
public class TrickySort {

    static int sortingCost(int N, int arr[]){
        // code here

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int val: arr){
            if(map.containsKey(val - 1) == false){
                map.put(val, 1);
            } else {
                map.put(val, map.get(val - 1) + 1);
            }

            max = Math.max(max, map.get(val));
        }

        return N - max;
    }
}
