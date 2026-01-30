package array_and_string;

public class NumberOfRects_1725 {
  public int countGoodRectangles(int[][] rectangles) {
    int [] maxSqrSide = new int[rectangles.length];
    int maxSqr = 0;

    for (int i = 0; i < rectangles.length; i++) {
      int[] curRect = rectangles[i];
      int curMaxSqr = curRect[0];
      if(curMaxSqr > curRect[1]) {
        curMaxSqr = curRect[1];
      }
      maxSqrSide[i] = curMaxSqr;
      if(maxSqr < curMaxSqr) {
        maxSqr = curMaxSqr;
      }
    }

    int count = 0;
    for (int i = 0; i < maxSqrSide.length; i++) {
      if (maxSqrSide[i] == maxSqr) {
        count++;
      }
    }

    return count;
  }
}
