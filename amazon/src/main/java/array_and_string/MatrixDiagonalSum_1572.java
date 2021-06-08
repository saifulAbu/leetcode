package array_and_string;

public class MatrixDiagonalSum_1572 {
  public int diagonalSum(int[][] mat) {
    int n = mat.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      res = res = mat[i][i] + mat[i][n - i - 1];
    }
    if () {

    }
    return res;
  }
}
