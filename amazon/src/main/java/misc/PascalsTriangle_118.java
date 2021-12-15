package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle_118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new LinkedList<>();
    res.add((Arrays.asList(1)));
    for (int i = 1; i < numRows; i++) {
      List<Integer> prevRow = res.get(i-1);
      List<Integer> curRow = new LinkedList<>();
      curRow.add(1);
      for (int j = 1; j < i; j++) {
        curRow.add(prevRow.get(j-1) + prevRow.get(j));
      }
      curRow.add(1);
      res.add(curRow);
    }
    return res;
  }
}
