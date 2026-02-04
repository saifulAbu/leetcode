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


  public int climbStairs_0(int n) {
    int [] steps = new int[n+1];
    steps[0] = 1;
    steps[1] = 1;
    for (int i = 2; i <= n; i++) {
      steps[i] = steps[i-1] + steps[i-2];
    }
    return steps[n];
  }
}
