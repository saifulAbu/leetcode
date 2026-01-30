package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
  List<List<Integer>> result = new LinkedList<>();
  int n;
  int k;
  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    helper(1, new LinkedList<Integer>());
    return result;
  }

  private void helper(int i, List<Integer> cur) {
    if (i > n) {
      return;
    }
    int remainingIncludingCur = n - i + 1;
    //not enough item available to put in it
    if (cur.size() + remainingIncludingCur < k) {
      return;
    }
    List<Integer> withAddingCur = new LinkedList<>(cur);
    withAddingCur.add(i);
    if (withAddingCur.size() == k) {
      result.add(withAddingCur);
    } else {
      helper(i+1, withAddingCur);
    }
    helper(i+1, cur);
  }

  public static void main(String args[]) {
    Combinations_77 c = new Combinations_77();
    c.combine(4, 2);
    System.out.println();
  }
}
