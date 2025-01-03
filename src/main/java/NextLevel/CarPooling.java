package NextLevel;

import java.util.PriorityQueue;

/**
 * @author : Kunal Sharma
 * @since : 14/08/22, Sunday
 **/
public class CarPooling {

    class Pair implements Comparable<Pair> {
        int time;
        int delta;

        Pair(int time, int delta){
            this.time = time;
            this.delta = delta;
        }

        public int compareTo(Pair o){
            if(this.time != o.time){
                return this.time - o.time;
            } else {
                if(this.delta < 0){
                    return -1;
                } else if(o.delta < 0){
                    return +1;
                } else {
                    return 0;
                }
            }
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int[] trip: trips){
            pq.add(new Pair(trip[1], +trip[0]));
            pq.add(new Pair(trip[2], -trip[0]));
        }

        int pic = 0;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            pic += rem.delta;

            if(pic > capacity){
                return false;
            } else if(pic < 0){
                pic = 0;
            }
        }

        return true;
    }
}
