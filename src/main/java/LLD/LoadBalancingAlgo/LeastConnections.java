package LLD.LoadBalancingAlgo;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class LeastConnections {

    private final Map<String, Integer> serverConnections;

    public LeastConnections(List<String> servers) {
        serverConnections = new HashMap<>();
        for (String server : servers) {
            serverConnections.put(server, 0);
        }
    }

    public String getNextServer() {
        return serverConnections.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void releaseConnection(String server) {
        serverConnections.computeIfPresent(server, (k, v) -> v > 0 ? v - 1 : 0);
    }

    public static void main(String[] args) {
        List<String> servers = new ArrayList<>(Arrays.asList("Server1", "Server2", "Server3"));
        LeastConnections leastConnectionsLB = new LeastConnections(servers);

        for (int i = 0; i < 6; i++) {
            String server = leastConnectionsLB.getNextServer();
            System.out.println(server);
            leastConnectionsLB.releaseConnection(server);
        }
    }
}
