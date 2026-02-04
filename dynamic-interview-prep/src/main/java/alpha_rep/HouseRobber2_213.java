package alpha_rep;

public class HouseRobber2_213 {
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
}
