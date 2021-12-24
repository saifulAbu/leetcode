package array_and_string;

import java.util.Arrays;

public class ClosestSum_16 {
  public int threeSumClosest(int[] arr, int target) {
    int minDiff = Integer.MAX_VALUE;
    int closestSum = Integer.MIN_VALUE;
    Arrays.sort(arr);
    int len = arr.length;
    int i = 0;
    while (i < len - 2) {
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int s = arr[i] + arr[j] + arr[k];
        int d = target - s;
        if (Math.abs(d) < minDiff) {
          minDiff = Math.abs(d);
          closestSum = s;
        }
        if (s < 0) {
          j++;
        } else if(s > 0) {
          k--;
        } else {
          break;
        }
      }
      if (minDiff == 0) {
        break;
      }
      i++;
    }
    return closestSum;
  }
}
