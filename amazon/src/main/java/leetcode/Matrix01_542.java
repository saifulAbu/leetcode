package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {
  private int R, C, SIZE;

  private void initializeConstants(int[][] mat) {
    R = mat.length;
    C = mat[0].length;
    SIZE = R * C;
  }

  private int[] convertTo1D(int[][] mat) {
    int [] oneD = new int[SIZE];
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        int i = r * C + c;
        oneD[i] = mat[r][c];
      }
    }
    return oneD;
  }

  private int[] runBFSToFindDistance(int[] mat) {
    int[] distance = new int[SIZE];
    boolean[] seen = new boolean[SIZE];
    Queue<Integer> q = new LinkedList<>();

    // add all the zeros to q
    for(int i = 0; i < SIZE; i++) {
      if(mat[i] == 0) {
        q.add(i);
        seen[i] = true;
      }
    }

    // neighbors
    int[] NEIGHBOR_OFFSETS = {1, -1, C, -C};
    //run bfs
    int curDistance = 0;
    while(!q.isEmpty()) {
      int curSize = q.size();
      for(int i = 0; i < curSize; i++){
        int cellId = q.poll();
        distance[cellId] = curDistance;
        for(int offset : NEIGHBOR_OFFSETS) {
          int neighbor = cellId + offset;
          if(isValid(neighbor) && !seen[neighbor]) {
            seen[neighbor] = true;
            q.add(neighbor);
          }
        }
      }
      curDistance++;
    }
    return distance;
  }

  int[][] convertTo2d(int[] oneD) {
    int[][] twoD = new int[R][C];
    for(int i = 0; i < SIZE; i++) {
      int r = i / C;
      int c = i % C;

      twoD[r][c] = oneD[i];
    }
    return twoD;
  }

  private boolean isValid(int id) {
    return id >= 0 && id < SIZE;
  }

  public int[][] updateMatrix(int[][] mat) {
    initializeConstants(mat);
    int[] oneD = convertTo1D(mat);
    int[] distances1D = runBFSToFindDistance(oneD);
    return convertTo2d(distances1D);
  }


}

class Matrix01_0_542 {
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
