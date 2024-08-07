package Graph;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class CycleDetectDirectedDFS {

    public boolean isCycleDFS(List<Integer>[] adj, int u, boolean[] visited, boolean[] inCurrentRecursion) {
        visited[u] = true;
        inCurrentRecursion[u] = true;

        for (int v : adj[u]) {
            // If not visited, then check for cycle in DFS
            if (!visited[v] && isCycleDFS(adj, v, visited, inCurrentRecursion)) {
                return true;
            } else if (inCurrentRecursion[v]) {
                return true;
            }
        }

        inCurrentRecursion[u] = false; // backtrack
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCycleDFS(adj, i, visited, inRecursion)) {
                return true;
            }
        }

        return false;
    }
}
