package alpha_rep;

public class HouseRobber_198 {
  public int rob(int[] nums) {
    /*
    * profit[i] = maxProfit(steal i th house, not steal ith house)
    *
    * if we steal ith house = take profit from ith house + profit at (i+2)th house
    * if we don't steal ith house = profit of (i+1)th house
    *
    * */
    int N = nums.length;
    if(N == 1) {
      return nums[0];
    }
    int[] profit = new int[N];
    profit[0] = nums[0];
    profit[1] = Math.max(nums[0], nums[1]);

    for(int i = 2; i < N; i++) {
      profit[i] = Math.max(nums[i] + profit[i-2], profit[i-1]);
    }

    return profit[N - 1];

  }

  public int rob_1(int[] nums) {
    int n = nums.length;
    int[] profit = new int[n];
    profit[0] = nums[0];
    profit[1] = Math.max(profit[0], nums[1]);

    for(int i = 2; i < n; i++) {
      profit[i] = Math.max(nums[i] + profit[i-2], profit[i-1]);
    }

    return profit[n-1];
  }

  public int rob_2(int[] nums) {
    return rob_rec_helper(nums, nums.length - 1);
  }

  public int rob_rec_helper(int[] nums, int i) {
    if(i < 0) {
      return 0;
    }
    return Math.max(nums[i] + rob_rec_helper(nums, i - 2), rob_rec_helper(nums, i-1));
  }

  public int rob_0(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int [] profit = new int[nums.length];
    profit[0] = nums[0];
    profit[1] = Math.max(nums[1], nums[0]);

    for (int i = 2; i < profit.length; i++) {
      profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
    }

    return profit[profit.length-1];
  }

  public int rob_3(int[] nums) {
    int n = nums.length;
    if(n == 1) {
      return nums[0];
    }

    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Integer.max(dp[0], nums[1]);

    for(int i = 2; i < n; i++) {
      dp[i] = Integer.max(dp[i-2] + nums[i], dp[i-1]);
    }

    return dp[n-1];
  }

  public int rob_4(int[] nums) {
    int prev2 = 0, prev1 = 0;

    for(int i = 0; i < nums.length; i++) {
      int cur = Math.max(prev1, prev2 + nums[i]);
      prev2 = prev1;
      prev1 = cur;
    }

    return prev1;
  }

  public int rob_0531(int[] nums) {
    int robA = 0, robB = 0;

    for(int i = 0; i < nums.length; i++) {
      int robC = Math.max(nums[i] + robA, robB);
      robA = robB;
      robB = robC;
    }
    return robB;
  }
}
