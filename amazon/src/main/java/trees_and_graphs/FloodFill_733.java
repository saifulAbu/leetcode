package trees_and_graphs;

public class FloodFill_733 {
  int[][] image;
  int oldColor;
  int newColor;
  int m, n;
  int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    this.image = image;
    this.oldColor = image[sr][sc];
    this.m = image.length;
    this.n = image[0].length;
    this.newColor = newColor;
    if(newColor == oldColor) {
      return image;
    }
    dfs(sr, sc);
    return image;
  }

  private void dfs(int r, int c) {
    if (r < 0 || r >= m || c < 0 || c >= n) {
      return;
    }
    if (image[r][c] != oldColor) {
      return;
    }
    image[r][c] = newColor;
    for (int[] direction : directions) {
      dfs(r + direction[0], c + direction[1]);
    }
  }
}
