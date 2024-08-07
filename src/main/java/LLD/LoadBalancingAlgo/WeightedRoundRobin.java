package LLD.LoadBalancingAlgo;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 02/08/24, Friday
 **/
public class WeightedRoundRobin {
    private final Map<String, Integer> serverWeights;
    private int currentWeight;

    public WeightedRoundRobin(Map<String, Integer> serverWeights) {
        this.serverWeights = new HashMap<>(serverWeights);
        this.currentWeight = serverWeights.values().stream().max(Integer::compare).orElse(0);
    }

    public Optional<String> getNextServer() {
        for (String server : serverWeights.keySet()) {
            int weight = serverWeights.get(server);
            if (weight >= currentWeight) {
                currentWeight = weight - 1; // Decrement weight after selection
                return Optional.of(server);
            }
        }
        currentWeight = serverWeights.values().stream().max(Integer::compare).orElse(0); // Reset weight on full cycle
        return Optional.empty();
    }

    public static void main(String[] args) {
        Map<String, Integer> serverWeights = new HashMap<>();
        serverWeights.put("Server1", 5);
        serverWeights.put("Server2", 1);
        serverWeights.put("Server3", 1);

        WeightedRoundRobin weightedRoundRobinLB = new WeightedRoundRobin(serverWeights);

        for (int i = 0; i < 7; i++) {
            Optional<String> server = weightedRoundRobinLB.getNextServer();
            if (server.isPresent()) {
                System.out.println(server.get());
            } else {
                System.out.println("No server available with sufficient weight");
            }
        }
    }
}
