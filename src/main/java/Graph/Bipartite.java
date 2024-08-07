package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 19/07/24, Friday
 **/
public class Bipartite {

    //  Time Complexity: O(V+E)
//  Space Complexity: O(V+E)
    public boolean checkBipartiteDFS(ArrayList<Integer>[] adj, int curr, int[] color, int currColor) {
        color[curr] = currColor; // color the current node

        // Explore adjacent nodes
        for (int neighbour : adj[curr]) {
            if (color[neighbour] == color[curr])
                return false; // found a conflict means same color

            if (color[neighbour] == -1) { // not colored yet (not visited)
                int colorOfV = 1 - currColor; // alternate color

                if (!checkBipartiteDFS(adj, neighbour, color, colorOfV))
                    return false;
            }
        }

        return true;
    }

    public boolean isBipartiteViaDFS(int V, ArrayList<Integer>[] adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // initialize color array

        // Try to color each component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBipartiteDFS(adj, i, color, 1))
                    return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        ArrayList<Integer>[] adj = new ArrayList[V];

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
            for (int neighbor : graph[i]) {
                adj[i].add(neighbor);
            }
        }


        return isBipartiteViaDFS(graph.length, adj);
    }

    // approach 2

    public boolean checkBipartiteBFS(ArrayList<Integer>[] adj, int curr, int[] color, int currColor) {
        color[curr] = currColor; // color the current node

        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int neighbour : adj[u]) {
                if (color[neighbour] == color[u]) {
                    return false; // found a conflict
                } else if (color[neighbour] == -1) { // not colored yet (not visited)
                    color[neighbour] = 1 - color[u]; // alternate color
                    queue.add(neighbour);
                }
            }
        }

        return true;
    }

}
