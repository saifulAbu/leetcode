package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII_119 {
  public List<Integer> getRow(int rowIndex) {
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