package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 20/03/22 3:08 PM
 */

public class CountOfEqual0sAnd1s {


    //Function to count sub-arrays with 1s and 0s.
    // Longest Subarray

    public static void main(String[] args) {
        System.out.println(countSubarrWithEqualZeroAndOne(new int[] {0,1,0,0,1,1,0,1,0,0,1,1,1,1,0} ,15));
        int[] ints = {1, 1, 0, 1, 1, 0, 1, 0, 0, 1};
        System.out.println(longestSubarrayOf0sAnd1s(ints , ints.length));
    }

    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
     // using frequnency

        int ans = 0;


        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(sum, 1);


        for (int val : arr) {

            sum += (val == 0 ? -1 : 1);


            if (map.containsKey(sum)) {

                ans += map.get(sum);

                map.put(sum, map.get(sum) + 1);

            } else {

                map.put(sum, 1);

            }

        }

        System.out.println(map);

        return ans;

    }

    static int longestSubarrayOf0sAnd1s(int[] num , int len)
    {
        // using index

        int sum = 0;
        int max_len = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(sum,-1);

        for(int i = 0 ; i < num.length ; i++)
        {
            if((num[i] == 0))
            {
                sum += -1;
            }
            else if(num[i] == 1)
            {
                sum += 1;
            }

            if(map.containsKey(sum))
            {
                Integer val = map.get(sum);
                max_len = i - val;
            }
            else
            {
                map.put(sum,i);
            }
        }

        System.out.println(map);

        return max_len;
    }

}
