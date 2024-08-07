package LLD.LoadBalancingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class RoundRobin {

    private final List<String> servers;
    private final AtomicInteger index;

    public RoundRobin(List<String> servers) {
        this.servers = servers;
        this.index = new AtomicInteger(-1);
    }

    public String getNextServer() {
        int val =  index.incrementAndGet();
        System.out.println("Index of count is at : " + val);
        int currentIndex = val % servers.size();
        return servers.get(currentIndex);
    }

    public static void main(String[] args) {
        List<String> servers = new ArrayList<>(Arrays.asList("Server1", "Server2", "Server3"));
        RoundRobin roundRobinLB = new RoundRobin(servers);

        for (int i = 0; i < 6; i++) {
            System.out.println(roundRobinLB.getNextServer());
        }
    }
}
