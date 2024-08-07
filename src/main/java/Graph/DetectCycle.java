package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
// T.C. = O( V + E )
// S.C. = O( V )

// Here did on undirected cycle
public class DetectCycle {
    /************** Using DFS *************/

    public static boolean isCyclicInDFS(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];

        // Call helper function for each unvisited vertex
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && isCycleUtil(adjList, i, visited, -1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isCycleUtil(List<List<Integer>> adjList, int current, boolean[] visited, int parent) {
        visited[current] = true;

        for (int neighbor : adjList.get(current)) {
            if (neighbor == parent) {
                continue; // Skip due to coming from parent edge
            }

            if (visited[neighbor]) {
                return true; // Cycle detected if already visited
            }

            // Recursively explore unvisited neighbors
            if (isCycleUtil(adjList, neighbor, visited, current)) {
                return true;
            }
        }

        return false; // No cycle found in this subtree
    }

    public static void main(String[] args) {
        // Sample graph using adjacency list (modify as needed)
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>()); // Vertex 0
        adjList.get(0).add(1); // Edge between 0 and 1
        adjList.add(new ArrayList<>());
        adjList.get(1).add(2); // Edge between 1 and 2
        adjList.add(new ArrayList<>()); // Vertex 2 (no edges)
        adjList.add(new ArrayList<>());
        adjList.get(3).add(1); // Edge between 3 and 1 (cycle)

        for (List<Integer> list : adjList) {
            System.out.println(" list are : : " + list);
        }

        if (isCyclicInDFS(adjList)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }

        if (isCyclicInBFS(adjList)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }

    /************** Using BFS *************/
    static class Pair {
        int vertex;
        int parent;

        public Pair(int vertex, int parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    private static boolean isCyclicInBFS(List<List<Integer>> adjList) {
        int numVertices = adjList.size();
        boolean[] visited = new boolean[numVertices];

        // Explore from each unvisited vertex
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && isCycleUtilBFS(adjList, new Pair(i, -1), visited)) {
                return true;

            }
        }

        return false;
    }

    private static boolean isCycleUtilBFS(List<List<Integer>> adjList, Pair currentPair, boolean[] visited) {
        int vertex = currentPair.vertex;
        int parent = currentPair.parent;

        visited[vertex] = true;  // mark the vertex as visited

        for (int neighbor : adjList.get(vertex)) { // Explore unvisited neighbors
            if (!visited[neighbor]) {
                if (isCycleUtilBFS(adjList, new Pair(neighbor, vertex), visited)) {
                    return true;
                }
            } else if (neighbor != parent) { // Cycle detected if visited neighbor is not parent
                return true;
            }
        }

        return false; // No cycle found in this
    }

}
