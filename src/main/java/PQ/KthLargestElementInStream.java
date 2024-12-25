package PQ;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 12/08/24, Monday
 **/
public class KthLargestElementInStream {

    // optimal
    // S.C :-  O(k)
    static class KthLargestUsingMinHeap {

        PriorityQueue<Integer> pq;
        int kthLargest;

        public KthLargestUsingMinHeap(int k, int[] nums) {
            pq = new PriorityQueue<>(); // using min heap
            kthLargest = k;
            for (int num : nums) { // O(n log n)
                pq.offer(num);
            }
            while (pq.size() > k) {
                pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            while (pq.size() > kthLargest) { // O(log k)
                pq.poll();
            }
            return pq.peek();
        }

    }

    // NOT optimal
    // S.C :- O(n)
    static class KthLargestUsingMaxHeap {

        private PriorityQueue<Integer> pq;
        private int kthLargest;

        public KthLargestUsingMaxHeap(int k, int[] nums) {
            this.kthLargest = k;
            this.pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int num : nums) { // O(n log n)
                pq.offer(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            // Extract the max element k-1 times to get the k-th largest element
            PriorityQueue<Integer> copiedHeap = new PriorityQueue<>(pq);
            int result = 0;
            for (int i = 0; i < kthLargest; i++) {  // O(k log n)
                result = copiedHeap.poll();
            }
            return result;
        }

    }
}
