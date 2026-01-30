package binary_search;

public class Search2DMatrix_74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int R = matrix.length;
    int C = matrix[0].length;
    int l = 0, h = R - 1, m = 0, r = 0;
    while (l < h) {
      m = l + (h - l) / 2;
      int lowVal = matrix[l][0];
      int upVal = matrix[h][0];
      int mVal = matrix[m][0];
      if (mVal == target) {
        return  true;
      } else if(mVal < target) {
        int nextVal = m + 1 < R ? matrix[m+1][0] : Integer.MAX_VALUE;
        if (nextVal <= target) {
          l = m + 1;
          r = l;
        } else {
          r = m;
          break;
        }
      } else {
        h = m - 1;
      }
    }

    int[] searchSpace = matrix[r];
    l = 0;
    h = C - 1;
    m = 0;
    while (l < h) {
      m = l + (h - l) / 2;
      if (searchSpace[m] == target) {
        return true;
      } else if (searchSpace[m] > target){
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return searchSpace[l] == target? true : false;
  }
}
