package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kunal Sharma at 08/04/22 10:09 PM
 */
public class ReduceArraySizetoTheHalf {
    public static void main(String[] args) {
        minSetSize(new int[] {3,3,3,3,5,5,5,2,2,7});
    }

//    psvm

    // TC : O(nlogn)
    // Sc : O(n)
    public static int minSetSize(int[] arr) {
        int n = arr.length;
        // Element, Freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> freqs = new ArrayList<>(map.values());
        Collections.sort(freqs, Collections.reverseOrder());

        int count = 0;
        int totalEl = n;
        int i = 0;
        while(totalEl>n/2){
            totalEl = totalEl - freqs.get(i);
            i++;
            count++;
        }
        return count;

    }
}


//  4 3 2 1
//    6