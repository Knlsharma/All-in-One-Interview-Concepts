package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 20/03/22 4:08 PM
 */
public class CountOfEqual0s1sAnd2s {

    //User function Template for Java

    class Solution {

        long getSubstringWithEqual012(String str) {

            long ans = 0;


            // code here

            int c0 = 0;

            int c1 = 0;

            int c2 = 0;

            String key = "0#0";

            HashMap<String, Integer> map = new HashMap<>();


            map.put(key, 1);


            for (int i = 0; i < str.length(); i++) {

                char ch = str.charAt(i);

                if (ch == '0') {
                    c0++;
                } else if (ch == '1') {
                    c1++;
                } else {
                    c2++;
                }
                key = (c1 - c0) + "#" + (c2 - c1);

                if (map.containsKey(key)) {
                    int val = map.get(key);

                    ans += val;
                    map.put(key, val + 1);
                } else {
                    map.put(key, 1);
                }

            }
            return ans;

        }

    }
}
