package array_and_string;

public class CellWithOddValues_1252 {
  public int oddCells(int m, int n, int[][] indices) {
    int [][] base = new int[m][n];

    for(int [] index : indices) {
      int curR = index[0];
      int curC = index[1];
      //fill up row
      for(int c = 0; c < n; c++) {
        base[curR][c]++;
      }
      //fill up col
      for(int r = 0; r < m; r++) {
        base[r][curC]++;
      }
    }

    int count = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (base[r][c] % 2 != 0) {
          count++;
        }
      }
    }
    return count;
  }
}

// dummy comment
// dummy comment
// dummy comment
// dummy comment
// dummy comment
// dummy comment
