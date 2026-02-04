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
}
