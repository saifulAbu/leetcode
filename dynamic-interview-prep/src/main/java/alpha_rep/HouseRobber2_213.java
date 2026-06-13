package alpha_rep;

public class HouseRobber2_213 {

  public int rob_drona(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];

    return Math.max(
            robLinear(nums, 0, n - 2),
            robLinear(nums, 1, n - 1)
    );
  }

  private int robLinear(int[] nums, int s, int e) {
    int prev1 = 0, prev2 = 0;

    for (int i = s; i <= e; i++) {
      int pick = nums[i] + prev2;
      int skip = prev1;
      int cur = Math.max(pick, skip);

      prev2 = prev1;
      prev1 = cur;
    }

    return prev1;
  }

  public int rob(int[] nums) {
    /*
    * houses are ordered in circular order in this case
    * 0 1 2 3 => index
    * 1 2 3 4 => money
    *
    *    1
    *  /   \
    * 0     2
    *  \   /
    *    3
    *
    * 0 is not adjacent to 1 and 3
    *
    * if it were a linear case then this will be the orientation
    *  0 - 1 - 2 - 3
    *
    * so for the solution, we can either take 0 or 3. cannot consider both
    * so we check this linear cases for these indices
    * 0 - 1 - 2 or 1 - 2 - 3
    *
    * we return the max
    * */

    int N = nums.length;
    if(N == 1) {
      return nums[0];
    }
    int[] profit = new int[N];
    int maxProfit = 0;

    //first consider the case where we will take 0 index
    profit[0] = nums[0];
    profit[1] = Math.max(profit[0], nums[1]);

    // calculate upto index n-2. this guarantees n-1 index will not be computed
    for(int i = 2; i < N - 1; i++) {
      profit[i] = Math.max(profit[i-2] + nums[i], profit[i-1]);
    }
    maxProfit = profit[N-2];

    //reset profit values
    for(int i = 0; i < N; i++) {
      profit[i] = 0;
    }

    //now compute excluding 0. so we will put profit[0] = 0. this effectively excludes index 0
    profit[0] = 0;
    profit[1] = nums[1];

    // calculate all indices through n-1. now N-1 index will also be considered
    for(int i = 2; i < N; i++) {
      profit[i] = Math.max(profit[i-2] + nums[i], profit[i-1]);
    }
    maxProfit = Math.max(profit[N-1], maxProfit);
    return maxProfit;
  }

  public int rob_4_10(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];

    // Canonical approach: Max of robbing houses [0, n-2] or [1, n-1]
    return Math.max(robLinear_4_10(nums, 0, n - 2),
            robLinear_4_10(nums, 1, n - 1));
  }

  private int robLinear_4_10(int[] nums, int start, int end) {
    int prev2 = 0; // Represents rob(i-2)
    int prev1 = 0; // Represents rob(i-1)

    // Ensure the loop includes the 'end' index
    for (int i = start; i <= end; i++) {
      int temp = prev1;
      prev1 = Math.max(nums[i] + prev2, prev1);
      prev2 = temp;
    }
    return prev1;
  }

  public int rob_0531(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];
    return Math.max(rob_linear0531(0, n-2, nums), rob_linear0531(1, n-1, nums));
  }

  private int rob_linear0531(int s, int e, int[] nums) {
    int robA = 0, robB = 0;
    for(int i = s; i <= e; i++) {
      int robC = Math.max(nums[i] + robA, robB);
      robA = robB;
      robB = robC;
    }
    return robB;
  }
}
