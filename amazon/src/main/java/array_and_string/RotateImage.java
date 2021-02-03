package array_and_string;

public class RotateImage {
  public void rotate(int[][] matrix) {
    reflect(transpose(matrix));
  }

  private int[][] transpose(int[][] matrix){
    int N = matrix.length;
    for(int i = 0; i < N; i++) {
      for(int j = i; j < N; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
    return matrix;
  }

  private int[][] reflect(int[][] matrix) {
    int N = matrix.length;
    for(int c = 0; c < N / 2; c++) {
      for(int r = 0; r < N; r++) {
        int tmp = matrix[r][c];
        matrix[r][c] = matrix[r][N - 1 - c];
        matrix[r][N - 1 - c] = tmp;
      }
    }
    return matrix;
  }

  public static void main(String args[]) {
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    RotateImage ri = new RotateImage();
    ri.rotate(matrix);
  }
}
