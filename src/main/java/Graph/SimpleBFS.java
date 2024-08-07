package Graph;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
// T.C.:- O(V + E)
// S.C.:- O(V)
public class SimpleBFS {

    private static boolean visited[];
    static Map<Integer, List<Integer>> adjList;
    static Queue<Integer> queue;

    public static void bfs(Map<Integer, List<Integer>> adjList, int startVertex) {
        visited = new boolean[adjList.size()];
        queue = new LinkedList<>();

        queue.add(startVertex);  // add the starting vertex
        visited[startVertex] = true;  //mark the starting vertex

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " "); // Print the visited vertex (modify for your needs)

            List<Integer> neighbors = adjList.get(current);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        adjList = new HashMap<>();
        adjList.put(0, new LinkedList<>()); // Vertex 0
        adjList.get(0).add(1); // Edge between 0 and 1
        adjList.put(1, new LinkedList<>());
        adjList.get(1).add(2); // Edge between 1 and 2
        adjList.put(2, new LinkedList<>());
        adjList.put(3, new LinkedList<>());
        adjList.get(3).add(0); // Edge between 0 and 3
        adjList.put(4, new LinkedList<>());
        adjList.get(2).add(4); // Edge between 2 and 4

        bfs(adjList, 0); // Start BFS from vertex 0
    }
}
