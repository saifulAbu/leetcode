package dynamic_programing;

public class MaximumSubArr_53 {
  public int maxSubArray(int[] nums) {
    int maxSubArr = Integer.MIN_VALUE;
    int curSum = 0;
    int maxValue = Integer.MIN_VALUE;
    for (int num : nums) {
      if (curSum + num >= 0) {
        curSum += num;
        maxSubArr = Math.max(curSum, maxSubArr);
      } else {
        curSum = 0;
      }
      if (num > maxValue) {
        maxValue = num;
      }
    }
    if (maxValue < 0) {
      return maxValue;
    } else {
      return maxSubArr;
    }
  }
}
