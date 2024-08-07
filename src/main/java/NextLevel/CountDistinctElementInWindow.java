package NextLevel;

import java.util.HashMap;

/**
 * @author Kunal Sharma at 26/03/22 6:28 PM
 */
public class CountDistinctElementInWindow {


    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();

        String str = "1213423";

        int window = 4;

        for (int i = 0; i < window; i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map.size());

        int maintain_gap = 0;
        for (int i = window; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maintain_gap = i - window;
            char for_map = str.charAt(maintain_gap);

            if (map.get(for_map) == 1) {
                map.remove(for_map);
            } else {
                map.put(for_map, map.getOrDefault(for_map, 0) - 1);
            }
            System.out.println(map.size());
        }

    }
}
