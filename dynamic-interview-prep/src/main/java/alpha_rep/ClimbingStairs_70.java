package alpha_rep;

public class ClimbingStairs_70 {

  public int climbStairs(int n) {
    /*
    * if we have n = 3, we can have an array of size 4
    * count array looks the following
    * 0 1 2 3
    * 1 1 0 0
    * we will put count[0] = 1, count[1] = 1. this represents from 1st stair, we can go to 0th stair in 1 way.
    * then count[2] = count[0] + count[1] = 1 + 1 = 2. this matches our observation that we can take 1 step to go to step 1.
    * or we could  take 2 steps and reach stair 0.
    *
    * */

    int[] steps = new int[n+1];
    steps[0] = steps[1] = 1;

    for(int i = 2; i < n + 1; i++) {
      steps[i] = steps[i-1] + steps[i-2];
    }
    return steps[n];
  }

  public int climbStairs_memo_helper(int n) {
    int[] memo = new int[n+1];
    memo[0] = 1;
    memo[1] = 1;
    return climbStairs_memo_helper(n, memo);
  }

  public int climbStairs_memo_helper(int n, int[] memo) {
    if(memo[n] > 0) {
      return memo[n];
    }
    memo[n] = climbStairs_memo_helper(n-1, memo) + climbStairs_memo_helper(n-2, memo);
    return memo[n];
  }

  public int climbStairs_brute(int n) {
    if(n < 3) {
      return n; // for n = 1, we can do in 1 way, n = 2, we can do 2 ways
    }
    return climbStairs_brute(n-1) + climbStairs_brute(n-2);
  }


  public int climbStairs_0(int n) {
    int [] steps = new int[n+1];
    steps[0] = 1;
    steps[1] = 1;
    for (int i = 2; i <= n; i++) {
      steps[i] = steps[i-1] + steps[i-2];
    }
    return steps[n];
  }


  public int climbStairs_0405(int n) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <=n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
  }

  public int climbStairs_drona(int n) {
    if (n <= 2) return n;

    int a = 1; // ways(1)
    int b = 2; // ways(2)

    for (int i = 3; i <= n; i++) {
      int c = a + b; // ways(i) = ways(i-1) + ways(i-2)
      a = b;
      b = c;
    }

    return b; // ways(n)
  }
}
