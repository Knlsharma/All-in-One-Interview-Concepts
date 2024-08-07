package ThreadingPOC;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 10/02/24, Saturday
 **/

public class QueueSharedResource {

    public Queue<Integer> que;
    public int capacity;

    public QueueSharedResource(int capacity) {
        this.que = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce(int num) throws Exception {
        System.out.println("In Produced item " + num);
        while (que.size() == capacity)
        {
            System.out.println("FULL Q");
            wait();
        }
        System.out.println("going to add " + num);
        que.add(num);
        notify(); // if any consumer thread is waiting invoke notify

    }

    public synchronized int consume(int num) throws Exception {
        System.out.println("In Consumed item for " + num);
        while (que.isEmpty())
        {
            System.out.println("EMPTY Q");
            wait();
        }

        Integer polled = que.poll();
        System.out.println("Polled item is " + polled);
        notify(); // if any producer thread is waiting invoke notify
        return polled;
    }
}
