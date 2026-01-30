package dynamic_programing;

public class TargetSum_294 {
  public int findTargetSumWays(int[] nums, int target) {
    // exmplanation https://www.youtube.com/watch?v=hqGa65Rp5LQ
    // brief, positives will be summed up to s1 and negatives summed up to s2
    // we will just find how many ways we can sum s1, or how many subsets yields to s1
    int total = 0;
    for (int num : nums) {
      total += num;
    }
    int s1 = (total + target) / 2;
    int n = nums.length;
    int [][] dp = new int[n+1][s1 + 1];

    for (int c = 1; c <= s1; c++) {
      dp[0][c] = 0;
    }

    // only one way to make 0 using 0 elements
    for (int r = 1; r <= n; r++) {
      dp[r][0] = 1;
    }

    for (int r = 1; r <= n; r++) {
      for (int c = 1; c <= s1; c++) {
        int includeCurElem = (c - nums[r-1] < 0 ? 0 : dp[r-1][c - nums[r-1]]);
        int excludeCurElem = dp[r-1][c];
        dp[r][c] = includeCurElem + excludeCurElem;
      }
    }

    return dp[n+1][s1+1];
  }
}
