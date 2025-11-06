package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates_286 {
  int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int EMPTY = Integer.MAX_VALUE;
  int GATE = 0;
  int WALL = -1;
  public void wallsAndGates(int[][] rooms) {
    Queue<int[]> q = new LinkedList<>();
    int m = rooms.length;
    int n = rooms[0].length;
    //insert gates
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (rooms[r][c] == GATE) {
          q.offer(new int[] {r, c});
        }
      }
    }
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int[] curBloc = q.poll();
        int curR = curBloc[0];
        int curC = curBloc[1];
        int curVal = rooms[curR][curC];
        for (int [] direction : directions) {
          int nextR = curR + direction[0];
          int nextC = curC + direction[1];
          if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && rooms[nextR][nextC] == EMPTY) {
            rooms[nextR][nextC] = curVal +1;
            q.offer(new int[] {nextR, nextC});
          }
        }
      }
    }
  }
}
