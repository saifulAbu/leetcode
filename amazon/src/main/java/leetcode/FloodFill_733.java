package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FloodFill_733 {
  int R, C, PIXEL_ARRAY_SIZE;

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    R = image.length;
    C = image[0].length;
    PIXEL_ARRAY_SIZE = R * C;

    int[] pixel1D = convertTo1d(image);
    int startPixel = convertTo1d(sr, sc);
    Set<Integer> pixelsToColor = runBFSFindPixelsToColor(pixel1D, startPixel, newColor);
    colorPixels(image, pixelsToColor, newColor);
    return image;
  }

  private void colorPixels(int[][] image, Set<Integer> pixelsToColor, int newColor) {
    for(int pixel : pixelsToColor) {
      int r = pixel / C;
      int c = pixel % C;
      image[r][c] = newColor;
    }
  }

  private Set<Integer> runBFSFindPixelsToColor(int[] pixel1D, int startPixel, int newColor) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> pixelToColor = new HashSet<>();

    int[] NEIGHBOR_OFFSETS = {+1, -1, +C, -C};

    int oldColor = pixel1D[startPixel];
    q.add(startPixel);
    pixelToColor.add(startPixel);

    while(!q.isEmpty()) {
      int cur = q.poll();
      for(int neighborOffset : NEIGHBOR_OFFSETS) {
        int neighbor = cur + neighborOffset;
        if(isValid(neighbor) && pixel1D[neighbor] == oldColor && !pixelToColor.contains(neighbor)) {
          pixelToColor.add(neighbor);
          q.add(neighbor);
        }
      }
    }

    return pixelToColor;
  }

  private boolean isValid(int pixel) {
    return pixel >= 0 && pixel < PIXEL_ARRAY_SIZE;
  }

  private int[] convertTo1d(int[][] image) {
    int []  pixel1D = new int[PIXEL_ARRAY_SIZE];
    for(int r = 0; r < R; r++) {
      for(int c = 0; c < C; c++) {
        int i = convertTo1d(r, c);
        pixel1D[i] = image[r][c];
      }
    }
    return pixel1D;
  }

  private int convertTo1d(int r, int c) {
    return r * C + c;
  }
}

class FloodFill_0_733 {
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
