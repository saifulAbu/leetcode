package array_and_string;

import linkedlist.ListNode;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
  // 1 2 3 4
  // 5 6 7 8
  // 9 0 1 2
  // for the above array, we will first get all the outer elements of the array
  // 1 2 3 4 8 2 1 0 9 5
  // after this we will have  smaller problem of the following array
  // 6 7
  // 0 1
  // and we will continue printing the outer part of the array
  // notice startR and startC increases by 1 for the new smaller array
  // both R and C len decreases by 2
  public List<Integer> spiralOrder(int[][] matrix) {
    int lenR = matrix.length;
    int lenC = matrix[0].length;

    int rBegin = 0;
    int cBegin = 0;
    List<Integer> res = new LinkedList<>();

    while(lenR > 0 && lenC > 0) {
      int rEnd = rBegin + lenR - 1;
      int cEnd = cBegin + lenC - 1;

      // go right
      for(int r = rBegin, c = cBegin; c <= cEnd; c++) {
        res.add(matrix[r][c]);
      }

      // go down
      for(int r = rBegin + 1, c = cEnd; r <= rEnd; r++) {
        res.add(matrix[r][c]);
      }

      // for one row array, avoid reprint
      // otherwise print
      if(lenR > 1) {
        for(int r = rEnd, c = cEnd - 1; c >= cBegin; c--) {
          res.add(matrix[r][c]);
        }
      }

      // for one column array, we don't want to reprint
      if (lenC > 1) {
        // go up
        for(int r = rEnd - 1, c = cBegin; r > rBegin; r--) {
          res.add(matrix[r][c]);
        }
      }
      lenR -= 2;
      lenC -= 2;
      rBegin += 1;
      cBegin += 1;
    }

    return res;
  }

  public List<Integer> spiralOrder0(int[][] matrix) {
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

  private void print(int i) {
    System.out.print(i + " ");
  }

  private void println() {
    System.out.println();
  }

  private void print(List<Integer> res) {
    for(int i : res) {
      print(i);
    }
    println();
  }

  public static void main(String[] args) {

  }
}
