package alpha_rep;

public class BombEnemy_361 {
  public int maxKilledEnemies(char[][] grid) {
    /*
    * first imagine we can only damage to our left. then we can precompute left as following
    * for(r = 0; r < R; r++) {
    *   count = 0;
    *   for(int c = 0; c < C; c++) {
    *     if(grid[r][c] == 'E')
    *       count++
    *     else if(grid[r][c] == 'W')
    *       count = 0
    *     else grid[r][c] = count
    *   }
    * }
    *
    * compute, right, up and down similar way
    *
    * then go ahead and compute on each empty cell
    * for(r = 0; r < R; r++)
    *   for(c = 0; c < C; c++)
    *     if(grid[r][c] == '0')
    *       total = left[r][c] + right[r][c] + ...
    *       max = Max(total, max)
    *
    * */

    int R = grid.length, C = grid[0].length;
    int[][] left, right, up, down;
    left = new int[R][C];
    right = new int[R][C];
    up = new int[R][C];
    down = new int[R][C];

    //compute left
    for(int r = 0; r < R; r++) {
      int count = 0;
      for(int c = 0; c < C; c++) {
        if(grid[r][c] == 'E') {
          count++;
        } else if(grid[r][c] == 'W') {
          count = 0;
        } else {
          left[r][c] = count;
        }
      }
    }

    //compute right
    for(int r = 0; r < R; r++) {
      int count = 0;
      for(int c = C-1; c >= 0; c--) {
        if(grid[r][c] == 'E') {
          count++;
        } else if(grid[r][c] == 'W') {
          count = 0;
        } else {
          right[r][c] = count;
        }
      }
    }

    //compute up
    for(int c = 0; c < C; c++) {
      int count = 0;
      for(int r = 0; r < R; r++) {
        if(grid[r][c] == 'E') {
          count++;
        } else if(grid[r][c] == 'W') {
          count = 0;
        } else {
          up[r][c] = count;
        }
      }
    }

    //compute down
    for(int c = 0; c < C; c++) {
      int count = 0;
      for(int r = R - 1; r >= 0; r--) {
        if(grid[r][c] == 'E') {
          count++;
        } else if(grid[r][c] == 'W') {
          count = 0;
        } else {
          down[r][c] = count;
        }
      }
    }

    int maxDamage = 0;
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        if(grid[r][c] == '0') {
          int curDamage = left[r][c] + right[r][c] + up[r][c] + down[r][c];
          maxDamage = Math.max(maxDamage, curDamage);
        }
      }
    }

    return maxDamage;
  }
}
