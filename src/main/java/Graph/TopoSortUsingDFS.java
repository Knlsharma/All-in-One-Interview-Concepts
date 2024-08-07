package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
// T.C.:- O(V + E)
// S.C.:- O(V)
public class TopoSortUsingDFS {

    static class Graph {
        int numVertices;
        List<List<Integer>> adjList;

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            adjList = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dest) {
            adjList.get(src).add(dest);
        }
    }

    public static void topologicalSortUtil(Graph graph, int current, boolean[] visited, Stack<Integer> stack) {
        visited[current] = true;

        // Recursively explore unvisited neighbors (children)
        for (int neighbor : graph.adjList.get(current)) {
            if (!visited[neighbor]) {         // if neighbor is not visited
                topologicalSortUtil(graph, neighbor, visited, stack);
            }
        }

        // Push current vertex to stack after exploring all children (post-order)
        stack.push(current);
    }

    public static List<Integer> topologicalSort(Graph graph) {
        int numVertices = graph.numVertices;
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        // Explore unvisited vertices
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        // Sample graph using adjacency list (modify as needed)
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        List<Integer> topologicalOrder = topologicalSort(graph);
        System.out.println("Topological Sort Order:");
        for (int vertex : topologicalOrder) {
            System.out.print(vertex + " ");
        }
    }


}
