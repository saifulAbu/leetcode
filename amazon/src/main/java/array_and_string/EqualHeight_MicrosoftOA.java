package array_and_string;

import java.util.Arrays;

public class EqualHeight_MicrosoftOA {
  public int minSteps(int[] piles){
    int len = piles.length;
    if(len <= 1) return 0;
    Arrays.sort(piles);
    int res = 0, i = len - 2, countEqlHeight = 1;
    while (i >= 0) {
      if (piles[i] < piles[i+1]) {
        res += countEqlHeight;
      }
      countEqlHeight++;
      i--;
    }
    return res;
  }
  public static void main(String[] args) {
    int[][] testcases = {{5, 2, 1},  {4,5,5,4,2}};
    for(int[] testcase: testcases)
      System.out.println(new EqualHeight_MicrosoftOA().minSteps(testcase));
  }
}
//dummy to comver
