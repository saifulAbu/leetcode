package array_and_string;

public class DiagonalTraverse_498 {
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int i = 0;
    int j = 0;

    int [] res = new int[m*n];
    int k = 0;

    while (k < m * n) {
      //go diagonal up
      while (i >= 0 && j < n) {
        print(i, j);
        res[k++] = mat[i--][j++];
      }
      //restore valid i, j
      i++;
      j--;
      //move to right if possible otherwise, down
      if (j + 1 < n) {
        j++;
      } else {
        i++;
      }
      println();
      //go diagonal down
      while (i < m && j >= 0) {
        print(i, j);
        res[k++] = mat[i++][j--];
      }
      //restore to valid i, j
      i--;j++;
      if (i + 1 < m) {
        i++;
      } else {
        j++;
      }
      println();
    }
    return res;
  }

  private void print(int i, int j) {
    System.out.print(" (" + i + " ," + j + ") ");
  }

  private void println() {
    System.out.println();
  }

  public static void main(String args[]) {
    DiagonalTraverse_498 dt = new DiagonalTraverse_498();
    int [][] mat = {{1}, {1}, {1}, {1}};
    dt.findDiagonalOrder(mat);
  }

}
