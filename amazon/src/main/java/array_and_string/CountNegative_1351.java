package array_and_string;

public class CountNegative_1351 {
  public int countNegatives(int[][] grid) {
    int count = 0;
    for(int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if(grid[r][c] < 0) {
          count++;
        }
      }
    }
    return count;
  }
}
