package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 17/04/22 12:43 AM
 */
public class CountOfSubstringExactlyKUniqueChar {

    public static void main(String[] args) {

        String str = "affcgaebdacbadbgdecc";
//        System.out.println(solution("affcgaebdacbadbgdecc", 4));

        int countLessThenK = CountOfSubstringLessThenKUniqueChar.solution(str, 4);
        int countLessThenKMinus1 = CountOfSubstringLessThenKUniqueChar.solution(str, 3);

        int exact_count_for_k = countLessThenK - countLessThenKMinus1;
        System.out.println(exact_count_for_k);

    }

//    public static int solution(String str, int k) {
//
//        char[] chars = str.toCharArray();
//
//        int len = 0;
//        int i = 0;
//        int j = -1;
//        int subStringCount = 0;
//
//        Map<Character, Integer> map = new HashMap<>();
//
//        while (i < str.length() && j < i) {
//
//            // acquire strategy
//            while (i < str.length()) {
//                char ch = str.charAt(i);
//                map.put(ch, map.getOrDefault(ch, 0) + 1);
//
//                if (map.size() == k) {        // till calculate substring length for count
//                    int tlen = i - j;
//                    subStringCount += tlen;
//                    i++;
//                } else if (map.size() > k) {
//                    i++;
//                    break;
//                }
//                i++;
//            }
//
//            // release strategy
//            while (j < i) {
//                j++;
//                char c = str.charAt(j);
//                if (map.containsKey(c)) {
//                    Integer freq = map.get(c);
//                    if (freq == 1) {
//                        map.remove(c);
//                    } else {
//                        map.put(c, freq - 1);
//                    }
//                }
//                if (map.size() < k) {
//                    break;     // breaking going for acquire
//                }
//            }
//        }
//        System.out.println(subStringCount);
//        return len;
//
//    }
}
