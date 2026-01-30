package array_and_string;

public class DiagonalTraverse_498 {
  int R, C;

  public int[] findDiagonalOrder(int[][] mat) {
    R = mat.length;
    C = mat[0].length;

    int size = R * C;
    int [] res = new int[size];
    int dir = 1;
    int r = 0, c = 0;

    for(int i = 0; i < size; i++) {
      res[i] = mat[r][c];
      if(dir == 1) { // upward direction
        if(isValid(r - 1, c + 1)) { // diag-up
          r = r - 1;
          c = c + 1;
          continue;
        } else if (isValid(r, c + 1)) { // right
          c = c + 1;
        } else { //down
          r = r + 1;
        }
      } else {
        if(isValid(r + 1, c - 1)) { // diag down
          r = r + 1;
          c = c - 1;
          continue;
        } else if(isValid(r + 1, c)) { // down
          r = r + 1;
        } else { // right
          c = c + 1;
        }
      }

      dir *= -1;
    }

    return res;
  }

  private boolean isValid(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C) return false;
    return true;
  }

  public int[] findDiagonalOrder0(int[][] mat) {
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
