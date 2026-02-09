package alpha_rep;

public class PathWithMaxGold_1219 {
  int[][] grid;
  boolean[][] seen;
  int R, C;
  int[] R_OFFSET = {-1, 1, 0, 0};
  int[] C_OFFSET = {0, 0, -1, 1};

  public int getMaximumGold(int[][] grid) {
    /*
    * we will use dfs on each r, c
    *
    * dfs(r, c)
    *   check if valid
    *   if r, c is not valid, seen[r, c] grid[r, c] == 0 return
    *   seen[r,c] = true
    *   look at all four direction and find the max way
    *   seen[r, c] = false
    *   return grid[r,c] + maxFrom child
    * */
    R = grid.length;
    C = grid[0].length;
    this.grid = grid;

    seen = new boolean[R][C];
    int max = 0;
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        max = Math.max(max, dfs(r, c));
      }
    }
    return max;
  }

  private int dfs(int r, int c) {
    if(r < 0 || r >= R || c < 0 || c >= C || seen[r][c] || grid[r][c] == 0) {
      return 0;
    }

    seen[r][c] = true;
    int curMaxFromNeighbor = 0;
    // look at all directions
    for(int i = 0; i < 4; i++) {
      int rNext = r + R_OFFSET[i];
      int cNext = c + C_OFFSET[i];
      curMaxFromNeighbor = Math.max(curMaxFromNeighbor, dfs(rNext, cNext));
    }
    seen[r][c] = false;
    return grid[r][c] + curMaxFromNeighbor;
  }
}
