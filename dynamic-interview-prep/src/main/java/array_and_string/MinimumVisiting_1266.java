package array_and_string;

public class MinimumVisiting_1266 {
  public int minTimeToVisitAllPoints(int[][] points) {
    int step = 0;
    for(int i = 0; i < points.length - 1; i++){
      step += stepCount(points[i], points[i+1]);
    }
    return step;
  }

  private int stepCount(int[] p0, int[] p1) {
    int x1 = p1[0] - p0[0];
    int y1 = p1[1] - p0[1];

    if (x1 < 0) {
      x1 *= -1;
    }
    if (y1 < 0) {
      y1 *= -1;
    }

    int step1 = Math.min(x1, y1);
    int step2 = (x1 - step1) + (y1 - step1);

    return step1 + step2;
  }

  public static void main(String args[]) {
    MinimumVisiting_1266 m = new MinimumVisiting_1266();
    int [] p0 = {1, 1};
    int [] p1 = {3, 4};
    System.out.println(m.stepCount(p0, p1));
  }

}
