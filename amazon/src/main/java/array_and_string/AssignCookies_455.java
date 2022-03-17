package array_and_string;

import java.util.Arrays;

public class AssignCookies_455 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int sI = 0;
    while (sI < s.length && s[sI] < g[0]) {
      sI++;
    }
    int gI = 0;
    while (gI < g.length && sI < s.length && g[gI] <= s[sI]) {
      gI++;
    }

    return gI;
  }
}
