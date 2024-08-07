package HashMap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : Kunal Sharma
 * @since : 06/08/24, Tuesday
 **/
public class MinimumNumberOfPushesToTypeWord {

    // T.C : O(n) + O(26log26)
    // S.C : O(1)
    // Generic Solution
    public int minimumPushes(String word) {
        int[] mp = new int[26];

        for (char ch : word.toCharArray()) {
            mp[ch - 'a'] = 1; // Mentioned in the question, all letters will be distinct
        }

        // Descending order of frequency
        Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int freq = mpInteger[i];
            int pos = ((i / 8) + 1);
            ans += freq * pos;
        }
        return ans;
    }

    // T.C : O(n) + O(26log26)
    // S.C : O(1)
    // Generic Solution
    public int minimumPushes2(String word) {
        int[] mp = new int[26];

        for (char ch : word.toCharArray()) {
            mp[ch - 'a']++; // Mentioned in the question, duplicate letter are there
        }

        // Descending order of frequency
        Integer[] mpInteger = Arrays.stream(mp).boxed().toArray(Integer[]::new);
        Arrays.sort(mpInteger, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int freq = mpInteger[i];
            int pos = ((i / 8) + 1);
            ans += freq * pos;
        }
        return ans;
    }
}
