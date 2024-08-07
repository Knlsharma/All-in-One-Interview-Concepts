package Backtracking.NormalExample;

/**
 * @author : Kunal Sharma
 * @since : 26/05/24, Sunday
 **/
// TC : O(3^(m*n)) as Starting from every cell and excluded one cell
// SC : O(m*n)
public class UniquePath3 {

    private int m, n;
    private int emptyCells;
    private int result = 0;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int[][] grid, int currCount, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return;
        }

        if (grid[i][j] == 2) {
            if (currCount == emptyCells) {
                result++;
            }
            return;
        }

        grid[i][j] = -1;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(grid, currCount + 1, newI, newJ);
        }
        grid[i][j] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        emptyCells = 0;
        result = 0;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    emptyCells++;
                } else if (grid[i][j] == 1) {
                    emptyCells++;
                    startX = i;
                    startY = j;
                }
            }
        }

//        emptyCells++; // Walk over every non-obstacle square exactly once. // already handled
        int currCount = 0;

        dfs(grid, currCount, startX, startY);

        return result;
    }
}
