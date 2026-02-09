package alpha_rep;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathToFood_1730 {
  int R, C;
  boolean[][] seen;
  char[][] grid;

  public int getFood(char[][] grid) {
    /*
     * we will use bfs for this
     * first find the current position (r,c)
     *
     * q.add([r,c])
     * seen[r, c] = true
     *
     * pathLen = 0
     * while(!q.isEmpty() && !found)
     *   curQSize = q.Size()
     *   for(int i = 0;  i < curQSize; i++) {
     *     curCell = q.pop()
     *     if(curCell == food) {
     *       pathLen++;
     *       found = true;
     *       break;
     *     }
     *     for(direction : directions)
     *       neighorCell = curCell + direction
     *       if(neighobrCell is valid and neighborCell is not seen and neighborCell = path)
     *         q.add(neighborCell)
     *   }
     *   pathLen++;
     *
     *  return found ? pathLen : -1;
     * */

    this.grid = grid;
    R = grid.length;
    C = grid[0].length;
    seen = new boolean[R][C];

    Deque<int[]> q = new LinkedList<>();
    boolean foundCurPosition = false;
    for(int r = 0; r < R && !foundCurPosition; r++) {
      for(int c = 0; c < C && !foundCurPosition; c++) {
        if(grid[r][c] == '*') {
          q.add(new int[] {r, c});
          seen[r][c] = true;
          foundCurPosition = true;
        }
      }
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int pathLen = 0;
    boolean foundFood = false;
    while(!q.isEmpty() && !foundFood) {
      int curQSize = q.size();
      for(int i = 0; i < curQSize && !foundFood; i++) {
        int[] curPos = q.poll();
        for(int[] direction : directions) {
          int nextR = curPos[0] + direction[0];
          int nextC = curPos[1] + direction[1];
          if(isValid(nextR, nextC) && !seen[nextR][nextC] && (grid[nextR][nextC] != 'X')) {
            if(grid[nextR][nextC] == '#') {
              foundFood = true;
              break;
            }
            q.offer(new int[] {nextR, nextC});
            seen[nextR][nextC] = true;
          }
        }
      }
      pathLen++;
    }
    return foundFood? pathLen : -1;
  }

  private boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }
}
