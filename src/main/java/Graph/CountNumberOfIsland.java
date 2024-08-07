package Graph;

/**
 * @author : Kunal Sharma
 * @since : 10/03/24, Sunday
 **/
public class CountNumberOfIsland {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[i].length ; j++)
            {
                drawtree(grid, i,j, visited);
                count++;
            }
        }

        return count;
    }

    private void drawtree(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length ||
                grid[i][j] == '1' || visited[i][j])
        {
            return;
        }
        visited[i][j] =  true;
        drawtree(grid, i-1, j, visited);
        drawtree(grid, i+1, j, visited);
        drawtree(grid, i, j-1, visited);
        drawtree(grid, i, j+1, visited);
    }

}
