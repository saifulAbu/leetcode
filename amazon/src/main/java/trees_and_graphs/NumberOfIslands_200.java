package trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {
  boolean [][] visited;
  int m, n;
  int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  char [][] grid;
  public int numIslands(char[][] grid) {
    this.grid = grid;
    m = grid.length;
    n = grid[0].length;
    visited = new boolean[m][n];
    int numIsland = 0;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == '1' && !visited[r][c]) {
          bfs(r, c);
          numIsland++;
        }
      }
    }
    return numIsland;
  }
  private void bfs(int r, int c) {
    Queue<int []> q = new LinkedList<>();
    visited[r][c] = true;
    q.offer(new int[] {r, c});
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        int[] curBlock = q.poll();
        int curR = curBlock[0];
        int curC = curBlock[1];
        for (int []direction : directions) {
          int nextR = curR + direction[0];
          int nextC = curC + direction[1];
          if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && visited[nextR][nextC] == false && grid[nextR][nextC] == '1') {
            visited[nextR][nextC] = true;
            q.offer(new int[] {nextR, nextC});
          }
        }
      }
    }
  }
}
