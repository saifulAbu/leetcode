package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle_118 {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new LinkedList<>();
    res.add(Arrays.asList(1));
    for(int curRowIndex = 1; curRowIndex < numRows; curRowIndex++) {
      List<Integer> curRow = new LinkedList<>();
      List<Integer> prevRow = res.get(curRowIndex - 1);
      curRow.add(1);
      // 0 : 1
      // 1 : 1 1
      // 2 : 1 2 1
      // 3 : 1 3 3 1
      // at row 3, maxSize = 4
      int curRowMaxSize = curRowIndex + 1;
      // at row 3, want to fill upto 4 - 2 = 2 index
      for(int c = 1; c < curRowMaxSize - 1; c++) {
        curRow.add(prevRow.get(c-1) + prevRow.get(c));
      }
      // fill up the last element with a 1
      curRow.add(1);
      res.add(curRow);
    }
    return res;
  }


  public List<List<Integer>> generate1(int numRows) {
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
