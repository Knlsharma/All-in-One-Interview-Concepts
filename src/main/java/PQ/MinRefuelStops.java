package PQ;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author : Kunal Sharma
 * @since : 28/05/23, Sunday
 **/
public class MinRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int range = startFuel;
        int stops = 0;
        int idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(range < target){
            while(idx < stations.length && stations[idx][0] <= range){
                pq.add(stations[idx][1]);
                idx++;
            }

            if(range >= target){
                return stops;
            } else if(pq.isEmpty()){
                return -1;
            } else {
                int petrol = pq.remove();
                range += petrol;
                stops++;
            }
        }

        return stops;
    }
}
