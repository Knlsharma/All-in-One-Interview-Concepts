package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 17/04/22 12:26 AM
 */
public class CountOfSubstringLessThenKUniqueChar {
    public static void main(String[] args) {

        System.out.println(solution("affcgaebdacbadbgdecc", 4));

    }

    public static int solution(String str, int k) {

        char[] chars = str.toCharArray();

//        int len = 0;
        int i = 0;
        int j = -1;
        int start = 0;
        int end = 0;
        int subStringCount = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (i < str.length() && j < i) {

            // acquire strategy
            while (i < str.length()) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() <= k) {        // till calculate substring length for count
                    int tlen = i - j;
                    subStringCount += tlen;
                    i++;
                } else {
                    i++;
                    break;
                }
            }

            // release strategy
            while (j < i) {
                j++;
                char c = str.charAt(j);
                if (map.containsKey(c)) {
                    Integer freq = map.get(c);
                    if (freq == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, freq - 1);
                    }
                }
                if (map.size() <= k) {
                    break;     // breaking going for acquire
                }
            }
        }
//        System.out.println("max len found was " + len);
        return subStringCount;

    }
}
