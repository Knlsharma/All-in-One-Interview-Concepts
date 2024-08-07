package Graph;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class CourseSchedule2 {

    // Approach 1 : BFS + TOPO :- O(V + E) for T.C. and S.C.
    int[] inDegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] courseArray : prerequisites) {
            int course = courseArray[0];
            int prerequisiteCourse = courseArray[1];

            // Add the course as a neighbor to its courseArray course
            if (!adjList.containsKey(prerequisiteCourse)) {
                adjList.put(prerequisiteCourse, new ArrayList<>());
            }
            adjList.get(prerequisiteCourse).add(course);

            // Increase the degree of the course
            inDegree[course]++;
        }
        return topologicalSortCheck(adjList, numCourses, inDegree);
    }

    public int[] topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> que = new LinkedList<>();

        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {      // starting with degree 0
                count++;                 // increment count if degree becomes 0
                result.add(i);
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int u = que.poll();

            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    count++;      // increment count if indegree becomes 0
                    result.add(v);
                    que.offer(v);
                }
            }
        }

        if (count == n) {
            int[] resultArr = new int[count];
            resultArr = result.stream().mapToInt(i -> i).toArray();
            return resultArr;
        }
        return new int[0];
    }

    // Approach 2 : DFS :- O(V + E) for T.C. and S.C.

    boolean hasCycle = false;

    void DFS(Map<Integer, List<Integer>> adj, int u, boolean[] visited, Stack<Integer> st, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (inRecursion[v]) {
                hasCycle = true;
                return;
            }

            if (!visited[v]) {
                DFS(adj, v, visited, st, inRecursion); // children phele daal do
                if (hasCycle)
                    return;
            }
        }

        st.push(u);     // parent ko end m daalo
        inRecursion[u] = false;
    }

    public int[] findOrderViaDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        hasCycle = false;

        for (int[] prereq : prerequisites) {
            int a = prereq[0];
            int b = prereq[1];
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                DFS(adj, i, visited, st, inRecursion);
                if (hasCycle)
                    return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            result[idx++] = st.pop();
        }

        return result;
    }

}
