package Graph;

import java.util.*;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class CourseSchedule {

    // Approach 1 : BFS + TOPO :- O(V + E) for T.C. and S.C.
    int[] inDegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

    public boolean topologicalSortCheck(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> que = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {      // starting with degree 0
                count++;                 // increment count if degree becomes 0
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int u = que.poll();

            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    count++;      // increment count if indegree becomes 0
                    que.offer(v);
                }
            }
        }

        return count == n;
    }

    // Approach 2 : DFS :- O(V + E) for T.C. and S.C.

    public boolean canFinishViaDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            if (!adjList.containsKey(prerequisiteCourse)) {
                adjList.put(prerequisiteCourse, new ArrayList<>());
            }
            adjList.get(prerequisiteCourse).add(course);
        }

        // Step 2: Check for cycles using DFS
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycleDFS(i, adjList, visited, recursionStack)) {
                return false; // Cycle detected
            }
        }

        return true; // No cycle detected

    }

    private boolean hasCycleDFS(int course, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[course]) {
            return true; // Cycle detected
        }
        if (visited[course]) {
            return false; // Already visited, no cycle from this node
        }

        visited[course] = true;
        recursionStack[course] = true;

        if (adjList.containsKey(course)) {
            for (int neighbor : adjList.get(course)) {
                if (hasCycleDFS(neighbor, adjList, visited, recursionStack)) {
                    return true; // Cycle detected downstream
                }
            }
        }

        recursionStack[course] = false; // Backtrack
        return false;
    }
}
