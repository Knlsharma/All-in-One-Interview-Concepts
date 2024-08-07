package NextLevel;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 11/02/24, Sunday
 **/
public class SortCharactersByFrequency {

    public String frequencySort(String input) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> pollMap = maxHeap.poll();
            for (int i = 0; i < pollMap.getValue(); i++) {
                sb.append(pollMap.getKey());
            }
        }
        return sb.toString();
    }
}
