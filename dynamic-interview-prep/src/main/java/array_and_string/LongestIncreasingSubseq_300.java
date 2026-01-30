package array_and_string;

public class LongestIncreasingSubseq_300 {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int max = 1;
    for (int i = 1; i < nums.length; i++) {
      int cur = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          cur = Math.max(cur, dp[j] + 1);
        }
      }
      dp[i] = cur;
      max = Math.max(cur, max);
    }
    return max;
  }
}
