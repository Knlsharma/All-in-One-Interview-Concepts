package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
// T.C.:- O(V + E)
// S.C.:- O(V)
public class SimpleDFS {

    private static boolean visited[];
    static Map<Integer, List<Integer>> adjList;

    public static void dfs(Map<Integer, List<Integer>> adjList, int vertex) {
        if (visited[vertex]) {
            // already visited
            return;
        }
        visited[vertex] = true; // mark the vertex as visited
        System.out.print(vertex + " "); // Print the visited vertex

        List<Integer> neighbors = adjList.get(vertex); // fetch neighbors of the vertex

        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    dfs(adjList, neighbor); // Recursive call for exploration
                }
            }
        }
    }

    public static void main(String[] args) {
        // Sample graph using Map (modify as needed)
        adjList = new HashMap<>();
        adjList.put(0, new LinkedList<>()); // Vertex 0
        adjList.get(0).add(1); // Edge between 0 and 1
        adjList.put(1, new LinkedList<>());
        adjList.get(1).add(2); // Edge between 1 and 2
        adjList.put(2, new LinkedList<>());
        adjList.put(3, new LinkedList<>());
        adjList.get(3).add(0); // Edge between 0 and 3

        visited = new boolean[adjList.size()]; // Visited array to track visited vertices

        // Start DFS from a vertex (modify as needed)
        dfs(adjList, 0); // Start DFS from vertex 0

        for(Map.Entry<Integer, List<Integer>>  entry : adjList.entrySet())
        {
            System.out.println(" key : " + entry.getKey() + " value : " + entry.getValue());
        }
    }
}
