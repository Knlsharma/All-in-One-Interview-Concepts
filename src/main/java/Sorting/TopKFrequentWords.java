package Sorting;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 11/07/24, Thursday
 **/
public class TopKFrequentWords {


    // Time: O(n log n), Space: O(n)
    public List<String> topKFrequentUsingSorting(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Count frequencies of each word
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Convert map entries to list of pairs
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        // Sort list based on frequency and lexicographical order
        Collections.sort(entryList, (e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue().compareTo(e1.getValue());
        });

        // Extract top k frequent words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(entryList.get(i).getKey());
        }

        return result;
    }


//    Using Min-Heap (Time: O(n log k), Space: O(n))
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Count frequencies of each word
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Min-Heap based on frequency and lexicographical order
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue().equals(e2.getValue())) {
                    return e2.getKey().compareTo(e1.getKey());
                }
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        // Add entries to the heap
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Extract top k frequent words
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }

        return result;
    }
}
