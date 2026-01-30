package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
  List<List<Integer>> list = new LinkedList<>();
  public List<List<Integer>> permute(int[] nums) {
    LinkedList<Integer> input = new LinkedList<>();
    for (int num : nums) {
      input.addLast(num);
    }
    helper(input, new LinkedList<>());
    return list;
  }

  private void helper(LinkedList<Integer> input, LinkedList<Integer> curSoln) {
    if (input.isEmpty()) {
      list.add(new LinkedList<>(curSoln));
      return;
    }
    for (int i = 0; i < input.size(); i++) {
      int first = input.removeFirst();
      curSoln.addLast(first);
      helper(input, curSoln);
      curSoln.removeLast();
      input.addLast(first);
    }
  }
}
