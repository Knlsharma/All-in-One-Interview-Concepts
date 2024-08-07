package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 11/03/24, Monday
 **/
public class CustomSortString {

    class Solution {
        public String customSortString(String order, String s) {
            Map<Character, Integer> frequencyMap = new HashMap<>();

            for(char ch : s.toCharArray()) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }

            StringBuilder str = new StringBuilder();
            for(char ch : order.toCharArray()) {
                if(frequencyMap.containsKey(ch)) {
                    int frequency = frequencyMap.get(ch);
                    for(int i = 0; i < frequency; i++) {
                        str.append(ch);
                        frequencyMap.put(ch, frequencyMap.get(ch) - 1);
                    }
                }
            }

            for(char ch : frequencyMap.keySet()) {
                int frequency = frequencyMap.get(ch);
                for(int i = 0; i < frequency; i++) {
                    str.append(ch);
                }
            }

            return str.toString();

        }
    }
}
