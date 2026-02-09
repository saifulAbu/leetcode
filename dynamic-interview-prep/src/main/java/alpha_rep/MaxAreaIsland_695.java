package alpha_rep;

public class MaxAreaIsland_695 {
  public int maxAreaOfIsland(int[][] grid) {
    /*
    * we will use dfs
    * int dfs(r, c, grid, seen)
    *   //return if (r, c) is invalid or grid contains water or seen
    *   return 1 + dfs(r-1, c) + dfs(r+1, c) + grid(r, c-1) + grid(r, c+1)
    *
    * int maxArea(grid)
    *   for r
    *     for c
    *       max = Max(max, dfs(r, c))
    *     end for
    *   end for
    *   return max
    * */
    int R = grid.length, C = grid[0].length;
    int maxArea = 0;
    boolean [][] visited = new boolean[R][C];
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        maxArea = Math.max(maxArea, dfs(r, c, grid, visited));
      }
    }
    return maxArea;
  }

  private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
    int R = grid.length, C = grid[0].length;
    if(r < 0 || r >= R || c < 0 || c >= C) {
      return 0;
    }

    if(grid[r][c] == 0 || visited[r][c]) {
      return 0;
    }

    visited[r][c] = true;
    return 1 +
            dfs(r - 1, c, grid, visited)+
            dfs(r + 1, c, grid, visited)+
            dfs(r, c - 1, grid, visited)+
            dfs(r , c + 1, grid, visited);
  }
}
