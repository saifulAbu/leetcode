package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class MS_OS_0 {

  public int[] solution(int N) {
    // write your code in Java SE 8
    int[] res = new int[N];
    res[0] = Integer.MIN_VALUE;
    return res;
  }

  int find_min(int[] A) {
    int ans = 0;
    for (int i = 1; i < A.length; i++) {
      if (ans > A[i]) {
        ans = A[i];
      }
    }
    return ans;
  }
  public static void main(String args []) {
      int[] a = {1};
      MS_OS_0 sol = new MS_OS_0();
      System.out.println(sol.find_min(sol.solution(1)));
    System.out.println(sol.find_min(sol.solution(2)));
    System.out.println(sol.find_min(sol.solution(3)));
    System.out.println(sol.find_min(sol.solution(4)));
    System.out.println(sol.find_min(sol.solution(1000)));

      //System.out.println(Integer.MAX_VALUE);

  }
}
