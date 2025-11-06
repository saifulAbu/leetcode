package array_and_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII_119 {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new LinkedList<>();
    res.add(1);

    for(int i = 0; i < rowIndex; i++) {
      List<Integer> curRow = new LinkedList<>();
      curRow.add(1);
      for(int j = 1; j < res.size(); j++) {
        curRow.add(res.get(j-1) + res.get(j));
      }
      curRow.add(1);
      res = curRow;
    }
    return res;
  }

  public List<Integer> getRow0(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    res.add(1);
    long prev = 1l;
    for (int i = 1; i <= rowIndex; i++) {
      long next = (rowIndex + 1 - i) * prev / i;
      res.add((int)next);
      prev = next;
    }
    return res;
  }
}