package Sorting;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class SortCharacterByFrequency {

    // (Time: O(n log n))
    public String frequencySortViaPriorityQueue(String s) {
        // Create a map to store frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequencies of each character in string s
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Create a priority queue (max-heap) based on character frequencies
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue(); // sort by frequency (descending)
        });

        // Add all entries from freqMap to maxHeap
        maxHeap.addAll(freqMap.entrySet());

        // Build the result string based on characters and their frequencies from maxHeap
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int value = entry.getValue();
            while(value > 0) {
                result.append(String.valueOf(entry.getKey()));
                value--;
            }
        }

        return result.toString();
    }


//    (Time: O(n log n))
    public String frequencySortViaNormalSorting(String s) {
        // Create an array to store frequency of each character (ASCII values 0 to 122)
        int[] freq = new int[123]; // because characters are between 0 and 122 in ASCII

        // Count frequencies of each character in string s
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // Create a list of characters with their frequencies
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 123; i++) {
            if (freq[i] > 0) {
                characters.add((char) i);
            }
        }

        // Sort characters based on their frequencies in descending order
        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character ch1, Character ch2) {
                return freq[ch2] - freq[ch1];
            }
        });

        // Build the result string based on sorted characters and their frequencies
        StringBuilder result = new StringBuilder();
        for (char ch : characters) {
            while(freq[ch] > 0)
            {
            result.append(ch);
            }
        }

        return result.toString();
    }
}
