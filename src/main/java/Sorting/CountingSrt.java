package Sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class CountingSrt {
// best use case for small ranges

    // O( N + K )
    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {  // O( N )
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int numIndex = min; numIndex <= max; numIndex++) {     // O ( K )
            if (freqMap.containsKey(numIndex)) {
                int count = freqMap.get(numIndex);
                while (count > 0) {
                    nums[index++] = numIndex;
                    count--;
                }
            }
        }

        return nums;
    }
}
