package alpha_rep;

public class LongestIncreasingPath_329 {
  int [][]matrix;
  int R, C;
  int [][] cache;

  int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int longestIncreasingPath(int[][] matrix) {
    /*
    * we will use dfs with memoization to avoid re-computation
    * we don't need a seen array because we are going on ascending way.
    * dfs(i, j)
    *   // validate i,j
    *   if cache[i,j] != 0
    *     return cache[i, j]
    *   curMaxPath = 0
    *   for all 4 direction that has higher values
    *     curMaxPath = Max(dfs(p, q), curMaxPath)
    *   cache[i,j] = curMaxPath + 1
    *
    * complexity: O(mn) no repeated calculation
    * */
    R = matrix.length;
    C = matrix[0].length;
    this.matrix = matrix;
    cache = new int[R][C];

    int maxPath = 0;
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        maxPath = Math.max(maxPath, dfs(r, c));
      }
    }
    return maxPath;
  }

  int dfs(int r, int c) {
    System.out.println("R: " + R + " C: " + C);
    if(!isValid(r, c)) {
      return 0;
    }
    if(cache[r][c] != 0) {
      return cache[r][c];
    }
    int curMax = 0;
    for(int[] direction : directions) {
      int nextR = r + direction[0], nextC = c + direction[1];
      if(isValid(nextR, nextC) && matrix[r][c] < matrix[nextR][nextC]) {
        curMax = Math.max(curMax, dfs(nextR, nextC));
      }
    }
    cache[r][c] = 1 + curMax;
    return cache[r][c];
  }

  boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }
}
