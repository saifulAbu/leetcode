package backtracking;

import java.util.*;

public class GenerateParenthesis_22 {
  public List<String> generateParenthesis(int n) {
    List<String> res = new LinkedList<String>(helper(n));
    Collections.sort(res);
    return res;
  }

  private Set<String> helper(int n) {
    if (n == 0) {
      return new HashSet<String>((Arrays.asList("")));
    }
    Set<String> prev = helper(n - 1);
    Set<String> cur = new HashSet<String>();
    for (String p : prev) {
      cur.add("()" + p);
      cur.add(p + "()");
      cur.add("(" + p + ")");
    }
    return cur;
  }
}
