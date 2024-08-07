package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 20/03/22 5:18 PM
 */
public class SubarrayDivisibleByK {

    public static void main(String[] args) {
        System.out.println(subarrayDivisibleByK(new int[] {2,5,3,8,1,7,6,4,3} , 7));
    }

    public static int subarrayDivisibleByK(int[] nums, int k) {

        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(sum, 1);

        for (int val : nums) {

            sum += val;

            int rem_sum = sum % k;

            if (map.containsKey(rem_sum)) {
                ans += map.get(rem_sum);
                map.put(rem_sum, map.get(rem_sum) + 1);
            } else {
                map.put(rem_sum, 1);
            }

        }

        return ans;

    }

}
