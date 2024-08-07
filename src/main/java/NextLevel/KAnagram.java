package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 27/03/22 11:38 PM
 */
public class KAnagram {

    public static void main(String[] args) {
        String str = "abbaccdghhga";
        String pattern = "bddcaahiiabb";
        System.out.println(isKAnagram(str, pattern, 4));
    }

    private static boolean isKAnagram(String A, String B, int k) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : A.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int uncontain_counter = 0;

        for(Character ch :  B.toCharArray())
        {
            if(map.containsKey(ch))
            {
                if(map.get(ch) == 1)
                {
                    map.remove(ch);
                }
                else
                {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
            }
            else
            {
                uncontain_counter++;
            }
        }

        return uncontain_counter == k;
    }
}
