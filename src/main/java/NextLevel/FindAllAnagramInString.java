package NextLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kunal Sharma at 27/03/22 10:43 PM
 */
public class FindAllAnagramInString {
    public static void main(String[] args) {
        String str = "aabcddbckabcbdcbbabcdab";
        String pattern = "bbcad";
        findAllStartingChar(str, pattern);

    }

    private static void findAllStartingChar(String inputString, String pattern) {

        Map<Character, Integer> patterMap = new HashMap<>();
        for (Character ch : pattern.toCharArray()) {
            patterMap.put(ch, patterMap.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> inputStringMap = new HashMap<>();


        int window = 5;

        for (int i = 0; i < window; i++) {
            char ch = inputString.charAt(i);
            inputStringMap.put(ch, inputStringMap.getOrDefault(ch, 0) + 1);
        }

        if (patterMap.equals(inputStringMap)) {
            System.out.println("0");
        }

        int maintain_gap = 0;
        for (int i = window; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            inputStringMap.put(ch, inputStringMap.getOrDefault(ch, 0) + 1);

            maintain_gap = i - window;

            char for_map = inputString.charAt(maintain_gap);

            if (inputStringMap.get(for_map) == 1) {
                inputStringMap.remove(for_map);
            } else {
                inputStringMap.put(for_map, inputStringMap.getOrDefault(for_map, 0) - 1);
            }

            if (patterMap.equals(inputStringMap)) {
                System.out.println(maintain_gap + 1);
            }
        }
    }
}
