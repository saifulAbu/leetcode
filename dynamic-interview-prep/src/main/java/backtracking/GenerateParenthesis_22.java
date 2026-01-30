package backtracking;

import java.util.*;

public class GenerateParenthesis_22 {

  static public List<String> generateParenthesis(int n) {
    List<String> res = new LinkedList<String>();
    helper(res, new char[2 * n], 0, 0, 0, n);
    return res;
  }

  static private void helper(List<String> res, char [] builder, int i, int openCount, int closeCount,  int n) {
    if (i == 2 * n) {
       res.add(new String(builder));
       return;
    }
    if (openCount < n) {
      builder[i] = '(';
      helper(res, builder, i + 1, openCount + 1, closeCount, n);
    }

    if (openCount > closeCount) {
      builder[i] = ')';
      helper(res, builder, i + 1, openCount, closeCount+1, n);
    }
  }

  public static void main(String args[]) {
    generateParenthesis(2);
  }
}
