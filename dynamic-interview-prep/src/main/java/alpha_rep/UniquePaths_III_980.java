package alpha_rep;

public class UniquePaths_III_980 {
  int result = 0;
  int R, C;

  public int uniquePathsIII_drona(int[][] grid) {
    R = grid.length;
    C = grid[0].length;

    int totalWalkable = 0;
    int startR = 0, startC = 0;

    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (grid[r][c] != -1) totalWalkable++;
        if (grid[r][c] == 1) {
          startR = r;
          startC = c;
        }
      }
    }

    boolean[][] visited = new boolean[R][C];
    dfs_44(grid, visited, totalWalkable, startR, startC, 0);
    return result;
  }

  private void dfs_44(int[][] grid, boolean[][] visited, int totalWalkable,
                      int r, int c, int cellsVisited) {

    if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c] || grid[r][c] == -1) {
      return;
    }

    // If we reached the end cell
    if (grid[r][c] == 2) {
      if (cellsVisited + 1 == totalWalkable) {
        result++;
      }
      return;
    }

    visited[r][c] = true;

    int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] nb : neighbors) {
      dfs_44(grid, visited, totalWalkable, r + nb[0], c + nb[1], cellsVisited + 1);
    }

    visited[r][c] = false;
  }

}
