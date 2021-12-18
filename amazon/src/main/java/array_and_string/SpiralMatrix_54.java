package array_and_string;

import linkedlist.ListNode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;

    int r = R;
    int c = C;

    int i = 0, j = 0;

    List<Integer> res = new LinkedList<>();

    while (res.size() < R * C) {
      //go to right
      for (int p = 0; p < c; p++) {
        print(i, j);
        res.add(matrix[i][j++]);
      }
      if (res.size() == R * C) {
        break;
      }
      //restore j to left
      j--;
      //go down
      i++;
      println();
      //go down
      for (int p = 0; p < r - 1; p++) {
        print(i, j);
        res.add(matrix[i++][j]);
      }
      if (res.size() == R * C) {
        break;
      }
      println();

      //restore i to up
      i--;
      //move j to left
      j--;
      //go left
      for (int p = 0; p < c - 1; p++) {
        print(i, j);
        res.add(matrix[i][j--]);
      }
      if (res.size() == R * C) {
        break;
      }
      println();

      //restore j
      j++;
      //move i to up
      i--;
      //go up
      for (int p = 0; p < r - 2; p++) {
        print(i, j);
        res.add(matrix[i--][j]);
      }
      //start for next iteration
      //restore i back to proper row
      i++;
      //shift j to right
      j++;
      println();
      r -= 2;
      c -= 2;
    }

    return res;
  }
  private void print(int i, int j) {
    System.out.print(" (" + i + " ," + j + ") ");
  }

  private void println() {
    System.out.println();
  }

  public static void main(String[] args) {
    SpiralMatrix_54 sp = new SpiralMatrix_54();
    int [][] mat = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}, {1, 1, 1}};
    sp.spiralOrder(mat);
  }
}
