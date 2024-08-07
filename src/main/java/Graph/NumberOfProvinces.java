package Graph;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class NumberOfProvinces {

    // approach 1 below : TC = SC = O(N^2)
    private void dfs(int u, boolean[] visited, int[][] isConnected) {
        visited[u] = true;

        // Visit neighbors
        for (int v = 0; v < isConnected.length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                dfs(v, visited, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        // Adjacency list representation using HashMap of Lists
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Populate adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Perform DFS for each unvisited node to find connected components
        for (int i = 0; i < n; i++) {         // o(n)
            if (!visited[i]) {
                count++;
                dfs(i, visited, isConnected);     // o(n)
            }
        }

        return count;
    }


    // approach 2 below : TC = SC = O(N^2)
    private void bfs(Map<Integer, List<Integer>> adj, int u, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        visited[u] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // Visit neighbors
            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public int findCircleNumViaBFS(int[][] isConnected) {
        int n = isConnected.length;

        // Build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }

        // Initialize visited array
        boolean[] visited = new boolean[n];
        int count = 0;

        // Perform BFS for each unvisited node to find connected components
        for (int i = 0; i < n; i++) { // o(n)
            if (!visited[i]) {
                bfs(adj, i, visited); // o(n)
                count++;
            }
        }

        return count;
    }

}
