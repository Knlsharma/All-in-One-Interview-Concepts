package NextLevel;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 30/03/24, Saturday
 **/
public class SlidingWindowTemplate {

    //Approach-1 (Classic sliding window)
//T.C : O(n)
//S.C : O(1)
    public long countSubarrays1(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        int countMax = 0;

        while (j < n) {
            if (nums[j] == maxE) { // max count increments
                countMax++;
            }

            while (countMax >= k) {   // shrink the window
                result += n - j;

                if (nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }
            j++;
        }

        return result;
    }


    //Approach-2 (Without Sliding Window)
//T.C : O(n)
//S.C : O(n)

    public long countSubarrays2(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;

        long result = 0;

        List<Integer> maxIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxE) {
                maxIndices.add(i);
            }

            int size = maxIndices.size();
            if (size >= k) {
                int last_i = maxIndices.get(size - k);
                result += last_i + 1;
            }
        }

        return result;
    }


    //Approach-1 (With Nested Loop - Classic Sliding Window Template)
//T.C : O(n)
//S.C : O(n)

    public int maxSubarrayLength1(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int result = 0;

        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1); // fill the map with count

            while(i < j && map.getOrDefault(nums[j], 0) > k) { // shrink map
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }

            result = Math.max(result, j - i + 1); // calculate valid length

            j++;
        }

        return result;
    }

    //Approach-2 (Without nested loop)
//T.C : O(n)
//S.C : O(n)
    public int maxSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int result = 0;

        int culprit = 0;

        while(j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(map.get(nums[j]) == k + 1) {    // more culprit found
                culprit++;
            }

            if(culprit > 0) {   // shrinking thr window
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == k) {
                    culprit--;
                }
                i++;
            }

            if(culprit == 0) {   // Now check for valid length
                result = Math.max(result, j - i + 1);
            }
            j++;
        }

        return result;
    }

    //Approach  : Standard Sliding window Problem
//T.C : O(N)
//S.C : O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int n = nums.length;
        int count = 0;

        int left = 0;
        int right = 0;
        int prod = 1;

        while (right < n) {
            prod *= nums[right];

            while (prod >= k) {
                prod /= nums[left];
                left++;
            }

            count += (right - left) + 1;
            right++;
        }

        return count;
    }

}

