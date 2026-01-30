package array_and_string;

import java.util.Arrays;

public class AssignCookies_455 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int sI = 0, gI = 0;
    while (gI < g.length && sI < s.length) {
      if(g[gI] <= s[sI]) {
        gI++;
      }
      sI++;
    }

    return gI;
  }
}
