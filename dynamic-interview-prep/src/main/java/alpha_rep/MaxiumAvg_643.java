package alpha_rep;

public class MaxiumAvg_643 {
  public double findMaxAverage(int[] nums, int k) {
    int f = 0, len = nums.length;
    double maxSum = 0, curSum = 0;
    for(f = 0; f < k; f++) {
      curSum += nums[f];
    }
    maxSum = curSum;
    for(; f < len; f++) {
      int in = nums[f];
      int b = f - k;
      int out = nums[b];
      curSum = curSum + in - out;
      maxSum = Math.max(maxSum, curSum);
    }

    return maxSum / k;
  }
}
