package Graph;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
public class TopoSortUsingBFS {

    private static List<Integer> topologicalSort(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        Map<Integer, Integer> inDegreeMap = new HashMap<>(); // Track in-degree of each vertex

        // Calculate in-degree for each vertex
        for (int i = 0; i < numVertices; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegreeMap.put(neighbor, inDegreeMap.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add vertices with in-degree 0 (no incoming edges)
        for (int i = 0; i < numVertices; i++) {
            if (!inDegreeMap.containsKey(i) || inDegreeMap.get(i) == 0) {
                queue.add(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();

        // BFS exploration with in-degree processing
        while (!queue.isEmpty()) {
            int current = queue.poll();
            topologicalOrder.add(current);

            for (int neighbor : adjList.get(current)) {
                int newInDegree = inDegreeMap.get(neighbor) - 1;
                inDegreeMap.put(neighbor, newInDegree);

                if (newInDegree == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycles (not guaranteed for all DAGs)
        if (topologicalOrder.size() != numVertices) {
//            CycleDetectDirectedBFS  this is same
            return null; // Cycle detected (not a valid topological sort)
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        // Sample graph using adjacency list (modify as needed)
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>()); // Vertex 0
        adjList.get(0).add(1); // Edge between 0 and 1
        adjList.add(new ArrayList<>()); adjList.get(1).add(2); // Edge between 1 and 2
        adjList.add(new ArrayList<>()); // Vertex 2 (no edges)

        List<Integer> topologicalOrder = topologicalSort(adjList);

        if (topologicalOrder != null) {
            System.out.println("Topological Sort Order:");
            for (int vertex : topologicalOrder) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("Cycle detected in the graph (BFS may not work for all DAGs)");
        }
    }
}
