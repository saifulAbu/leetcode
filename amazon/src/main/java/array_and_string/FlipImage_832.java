package array_and_string;

public class FlipImage_832 {
  public int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    //rotate
    for(int r = 0; r < n; r++) {
      for(int c = 0; c < n / 2; c++) {
        int fc = n - 1 - c;
        int t = image[r][c];
        image[r][c] = image[r][fc];
        image[r][fc] = t;
      }
    }

    //invert
    for(int r = 0; r < n; r++) {
      for(int c = 0; c < n; c++) {
        if(image[r][c] == 0) {
          image[r][c] = 1;
        } else {
          image[r][c] = 0;
        }
      }
    }
    return image;
  }
}
