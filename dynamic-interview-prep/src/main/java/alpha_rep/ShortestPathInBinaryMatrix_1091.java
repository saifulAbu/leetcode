package alpha_rep;

import java.util.*;

public class ShortestPathInBinaryMatrix_1091 {
  int[][] grid;
  int R, C;
  boolean[][] seen;

  int[][] neighbors = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    /*
     * we will apply bfs here, will stop once we arrive to the destination node
     *
     *
     * */
    R = grid.length;
    C = grid[0].length;
    if(grid[0][0] != 0 || grid[R-1][C-1] != 0) {
      return -1;
    }

    if(R == 1  && C == 1) {
      return 1;
    }

    seen = new boolean[R][C];

    int pathLen = 1;
    Deque<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0});
    seen[0][0] = true;

    while(!q.isEmpty()) {
      int curQSize = q.size();
      for(int i = 0; i < curQSize; i++) {
        int[] curPos = q.poll();
        for(int[] neighbor : neighbors) {
          int nR = curPos[0] + neighbor[0], nC = curPos[1] + neighbor[1];
          if(isValid(nR, nC) && !seen[nR][nC] && grid[nR][nC] == 0) {
            if(nR == R -1 && nC == C - 1) {
              return pathLen + 1;
            }
            q.offer(new int[] {nR, nC});
            seen[nR][nC] = true;
          }
        }
      }
      pathLen++;
    }
    return -1;
  }

  private boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }


  /*
  int R = 0;
  int C = 0;
  int [][] directions = {
      {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
  };
  int [][] len;
  int [][] grid;

  public int shortestPathBinaryMatrix(int[][] grid) {
    R = grid.length;
    C = grid[0].length;
    if(R == 1 && grid[0][0] == 0) {
      return 1;
    }
    this.grid = grid;
    len = new int[R][C];

    Queue<int []> q = new ArrayDeque<>(R * C);
    int pathLen = 0;
    if (grid[0][0] == 0) {
      q.offer(new int[] {0, 0});
      len[0][0] = 1;
      pathLen++;
    }

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int curR = cur[0], curC = cur[1];
      for (int [] neighbor : getNeighbors(cur[0], cur[1])) {
        int nR = neighbor[0], nC = neighbor[1];
        len[nR][nC] = len[curR][curC] + 1;
        if (isDestination(neighbor)) {
          return len[nR][nC];
        }
        q.offer(neighbor);
      }
    }

    return -1;
  }

  private boolean isDestination(int[] neighbor) {
    int r = neighbor[0];
    int c = neighbor[1];
    if (r == R -1 && c == C - 1) {
      return true;
    }
    return false;
  }

  private List<int []> getNeighbors(int r, int c) {
    List<int []> neighbors = new LinkedList<>();
    for (int [] direction : directions) {
      int r_n = r + direction[0];
      int c_n = c + direction[1];
      if (isvalid(r_n, c_n) && grid[r_n][c_n] == 0 && len[r_n][c_n] == 0) {
        neighbors.add(new int[] {r_n, c_n});
      }
    }
    return neighbors;
  }

  private boolean isvalid(int r, int c) {
    if (r < 0 || r >= R || c < 0 || c >= C) {
      return false;
    }
    return true;
  }
   */
}
