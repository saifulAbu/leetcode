package backtracking;

import java.util.HashSet;

public class NQueens_52 {
  HashSet<Integer> cols = new HashSet<>();
  HashSet<Integer> diag = new HashSet<>();
  HashSet<Integer> antiDiag = new HashSet<>();
  int sol = 0;
  int n = 0;
  public int totalNQueens(int n) {
    this.n = n;
    helper(0);
    return sol;
  }

  private void helper(int r) {
    if (r == n) {
      sol++;
    }
    for (int c = 0; c < n; c++) {
      int diagVal = r + c;
      int aDiagVal = r - c;
      if (!cols.contains(c) && !diag.contains(diagVal) && !antiDiag.contains(aDiagVal)) {
        cols.add(c);
        diag.add(diagVal);
        antiDiag.add(aDiagVal);
        helper(r+1);
        cols.remove(c);
        diag.remove(diagVal);
        antiDiag.remove(aDiagVal);
      }
    }
  }
}
