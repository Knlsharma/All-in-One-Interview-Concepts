package NextLevel;

import java.util.HashMap;

/**
 * @author : Kunal Sharma
 * @since : 30/03/24, Saturday
 **/
public class SubarraysWithKDifferentIntegers {

    public int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;
        int i = 0;
        int j = 0;

        int count = 0;

        while(j < n) {

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(mp.size() > k) {
                // Shrink the window
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if(mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }

            count += (j - i + 1); // Ending at j
            j++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
        // here k =2 will contain 2 length subarrays and 1 length subarrays               |  k = 1 will contain 1 length subarrays
    }


    /** difficult to think **/
    public int subarraysWithKDistinctApproach2(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> mp = new HashMap<>();

        int i_chota = 0;
        int j = 0;
        int i_bada = 0;

        int result = 0;

        while(j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(mp.size() > k) { // invalid --> shrink kro array
                mp.put(nums[i_chota], mp.get(nums[i_chota]) - 1);
                if(mp.get(nums[i_chota]) == 0) {
                    mp.remove(nums[i_chota]);
                }
                i_chota++;
                i_bada = i_chota;  // update the i_bada
            }

            while(mp.get(nums[i_chota]) > 1) {  // to find smallest subarray
                mp.put(nums[i_chota], mp.get(nums[i_chota]) - 1);
                i_chota++;
            }

            if(mp.size() == k) {
                result += i_chota - i_bada + 1;
            }
            j++;
        }

        return result;
    }
}
