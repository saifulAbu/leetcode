package sorting_searching;

public class Search2DMat_240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int r = matrix.length - 1;
    int c = 0;
    while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
      int val = matrix[r][c];
      if (val > target) {
        r--;
      } else if (val < target) {
        c++;
      } else {
        return true;
      }
    }
    return false;
  }
}
