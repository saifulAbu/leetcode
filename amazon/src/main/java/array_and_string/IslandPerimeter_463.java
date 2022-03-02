package array_and_string;

public class IslandPerimeter_463 {
  int R, C;
  int [][] directions = {
      {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };
  public int islandPerimeter(int[][] grid) {
    R = grid.length;
    C = grid[0].length;

    int permim = 0;
    for (int r = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if(grid[r][c] == 0) {
          continue;
        }
        for (int [] dir : directions) {
          int neighborR = r + dir[0];
          int neighborC = c + dir[1];
          if (isOnBorder(neighborR, neighborC) || grid[neighborR][neighborC] == 0) {
            permim++;
          }
        }
      }
    }
    return permim;
  }

  private boolean isOnBorder(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C) {
      return true;
    }
    return false;
  }
}
