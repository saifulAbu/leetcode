package dynamic_programing;

public class CountingBits {
  public int[] countBits(int n) {
    int [] dp = new int[n];
    dp[0] = 0;
    boolean filled = false;
    int max = 1;
    while(!filled){
      for (int i = 0; i < max; i++) {
        if(i + max <= n) {
          dp[i+max] = dp[i] + 1;
        } else {
          filled = true;
          break;
        }
      }
      max = 2 * max;
    }
    return dp;
  }

  public static void main(String args[]) {
    CountingBits cb = new CountingBits();
    cb.countBits(2);
  }
}
