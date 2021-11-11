package dynamic_programing;

public class TD1_Fib {
  public static void main(String args[]) {
    int[] dp = new int[10];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i-1] + dp[i-2];
      System.out.println(dp[i]);
    }
  }
}
