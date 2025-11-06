package array_and_string;

import java.util.Arrays;

public class HeightChecker_1051 {
  public int heightChecker(int[] heights) {
    if(heights.length == 1) {
      return 0;
    }

    int mismatchCount = 0;
    int[] expected = heights.clone();
    Arrays.sort(expected);
    for(int i = 0; i < heights.length; i++) {
      if(heights[i] != expected[i]) {
        mismatchCount++;
      }
    }
    return mismatchCount;
  }

  public int heightChecker0(int[] heights) {
    int [] expected = heights.clone();
    Arrays.sort(expected);
    int mismatch = 0;
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != expected[i]) {
        mismatch++;
      }
    }
    return mismatch;
  }
}
