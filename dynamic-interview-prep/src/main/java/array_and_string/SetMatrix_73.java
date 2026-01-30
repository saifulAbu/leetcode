package array_and_string;

public class SetMatrix_73 {
  int R = 0;
  int C = 0;

  private void zeroRow(int[][] arr, int r) {
    for (int c = 0; c < C; c++) {
      arr[r][c] = 0;
    }
  }

  public void setZeroes(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    boolean zeroFirstRow = false;

    // check if we need to zero the first row
    for (int c = 0; c < C; c++) {
      if (matrix[0][c] == 0) {
        zeroFirstRow = true;
        break;
      }
    }

    // mark rows and columns for zero
    for (int r = 1; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (matrix[r][c] == 0) {
          matrix[r][0] = 0;
          matrix[0][c] = 0;
        }
      }
    }

    // zero row
    for (int r = 1; r < R; r++) {
      if (matrix[r][0] == 0) {
        zeroRow(matrix, r);
      }
    }

    //zero col
    for (int c = 0; c < C; c++) {
      if (matrix[0][c] == 0) {
        zeroCol(matrix, c);
      }
    }

    //zero first row
    if (zeroFirstRow) {
      zeroRow(matrix, 0);
    }
  }

  private void zeroCol(int[][] arr, int c) {
    for (int r = 0; r < R; r++) {
      arr[r][c] = 0;
    }
  }
}
