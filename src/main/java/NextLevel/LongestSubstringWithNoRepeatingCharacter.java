package NextLevel;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kunal Sharma at 03/04/22 4:59 PM
 */
public class LongestSubstringWithNoRepeatingCharacter {
    public static void main(String[] args) {
        String ans = getLongestSubstringWithNoRepeatingCharacter("acgbfiehidjchjfaedgb");
        System.out.println(ans);
    }

    private static String getLongestSubstringWithNoRepeatingCharacter(String str) {

          int max_len = Integer.MIN_VALUE;
          String res_string = null;
        Set<Character> set = new HashSet<>();
         int j = -1;
         int i = 0;
        while(i < str.length()) {

            char ch = 0;
            while (i < str.length())    // acquire until become invalid
            {
                ch = str.charAt(i);
                if(set.contains(ch)) {
                    break;
                }
                else {
                    set.add(ch);
                    i++;
                }
                 res_string = str.substring(j+1, i);   // As of now result string
            }

            // release until duplicate char removed
            while (set.contains(ch)) {
              set.remove(str.charAt(j+1));
              j++;
            }

            String substring = str.substring(j, i);
            int temp_len = substring.length();

            if(temp_len > max_len)
            {
                max_len = temp_len;
                res_string = substring;
            }
        }
        return res_string;
    }
}
