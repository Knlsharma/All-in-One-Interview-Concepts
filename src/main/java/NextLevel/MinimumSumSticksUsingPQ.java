package NextLevel;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Kunal Sharma at 21/04/22 6:30 PM
 */
public class MinimumSumSticksUsingPQ {

    public static void main(String[] args) {

        int[] arr = new int[] {14,7,2,19,6,11};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min_cost = 0;
        for(Integer element : arr)
        {
            pq.add(element);
        }

        while(pq.size() > 1)
        {
            int firstNum = pq.remove();
            int secondNum = pq.remove();
            int pollSum = firstNum + secondNum;
            min_cost += pollSum;
            pq.add(pollSum);
        }

        System.out.println(min_cost);











    }
}
