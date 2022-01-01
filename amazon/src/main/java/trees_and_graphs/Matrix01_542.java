package trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {
  public int[][] updateMatrix(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int[][] res = new int[m][n];
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> q = new LinkedList<>();
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (mat[r][c] == 0) {
          res[r][c] = 0;
          q.add(new int[] {r, c});
        } else {
          res[r][c] = -1;
        }
      }
    }

    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int[] cur = q.poll();
        int curR = cur[0];
        int curC = cur[1];
        for (int[] direction : directions) {
          int neighborR = curR + direction[0];
          int neighborC = curC + direction[1];
          if (neighborR < 0 || neighborR >= m || neighborC < 0 || neighborC >= n) {
            continue;
          }
          if (res[neighborR][neighborC] >= 0) {
            continue;
          }
          res[neighborR][neighborC] = res[curR][curC] + 1;
          q.offer(new int[] {neighborR, neighborC});
        }
      }
    }
    return res;
  }
}
