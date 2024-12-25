package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Kunal Sharma
 * @since : 28/08/24, Wednesday
 **/


public class CountSubIsland {

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // down, up, right, left


    //Approach-1 (DFS)
    //T.C : O(m*n)
    //S.C : O(1) //I am not considering the space taken by System Recursion stack
    // DFS
    private boolean checkSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }

        if (grid2[i][j] != 1) { // we only need to check land (grid2[i][j] == 1)
            return true;
        }

        grid2[i][j] = -1; // mark visited

        boolean result = (grid1[i][j] == 1); // grid1[i][j] must have 1 to be a sub-island

        // Perform DFS in all four directions (down, up, right, left)
        result = result & checkSubIsland(grid1, grid2, i + 1, j); // Down
        result = result & checkSubIsland(grid1, grid2, i - 1, j); // Up
        result = result & checkSubIsland(grid1, grid2, i, j + 1); // Right
        result = result & checkSubIsland(grid1, grid2, i, j - 1); // Left

        return result;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; // number of rows
        int n = grid2[0].length; // number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIsland(grid1, grid2, i, j)) { // Found a sub-island
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    /***************************/

    //Approach-2 (BFS)
    //T.C : O(m*n)
    //S.C : O(m*n) //Queue
    public int countSubIslands2(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; // rows
        int n = grid2[0].length; // cols

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIslandUsingBFS(grid1, grid2, i, j)) { // Found an island
                    subIslands++;
                }
            }
        }

        return subIslands;
    }

    // BFS
    private boolean checkSubIslandUsingBFS(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid1.length;
        int n = grid1[0].length;

        boolean result = true;

        Queue<int[]> queue = new LinkedList<>(); // Queue to perform BFS
        queue.offer(new int[]{i, j});
        grid2[i][j] = -1; // mark visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (grid1[x][y] != 1) { // grid1 must have 1 at the same coordinate
                result = false;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1) {
                    grid2[newX][newY] = -1; // mark visited
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return result;
    }
}
