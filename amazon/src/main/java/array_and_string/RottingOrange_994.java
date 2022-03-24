package array_and_string;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange_994 {
  public int orangesRotting(int[][] grid) {
    int R = grid.length;
    int C = grid[0].length;

    Queue<int[]> q = new ArrayDeque<>();
    int goodOrangeCount = 0;
    //count number of oranges
    //add bad oranges to queue
    for (int r  = 0; r < R; r++) {
      for (int c = 0; c < C; c++) {
        if (grid[r][c] == 1) {
          goodOrangeCount++;
        } else if (grid[r][c] == 2) {
          q.offer(new int[] {r, c});
        }
      }
    }
    if(goodOrangeCount == 0) return 0;

    int timeStamp = -1;
    int [][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int [] curBad = q.poll();
        int r = curBad[0];
        int c = curBad[1];
        for(int [] dir : dirs) {
          int nR = r + dir[0];
          int nC = c + dir[1];
          if (nR >=0 && nR < R && nC >= 0 && nC < C && grid[nR][nC] == 1) {
            grid[nR][nC] = 2;
            goodOrangeCount--;
            q.offer(new int[] {nR, nC});
          }
        }
      }
      timeStamp++;
    }

    return goodOrangeCount == 0? timeStamp : -1;
  }
}
