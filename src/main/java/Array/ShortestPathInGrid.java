package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class ShortestPathInGrid {
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Queue to hold the state (i, j, obstacles remaining)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, k});

        // 3D array to track visited states
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int curr_i = temp[0];
                int curr_j = temp[1];
                int obs = temp[2];

                if (curr_i == m - 1 && curr_j == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n) {
                        continue;
                    }

                    if (grid[new_i][new_j] == 0 && !visited[new_i][new_j][obs]) {
                        queue.add(new int[]{new_i, new_j, obs});
                        visited[new_i][new_j][obs] = true;
                    } else if (grid[new_i][new_j] == 1 && obs > 0 && !visited[new_i][new_j][obs - 1]) {
                        queue.add(new int[]{new_i, new_j, obs - 1});
                        visited[new_i][new_j][obs - 1] = true;
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
