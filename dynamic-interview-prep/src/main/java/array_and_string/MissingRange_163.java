package array_and_string;

import java.util.LinkedList;
import java.util.List;

public class MissingRange_163 {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new LinkedList<>();
    if(nums.length == 0 && lower == upper) {
      res.add(Integer.toString(lower));
      return res;
    }

    int expected = lower;
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (cur != expected) {
        put(expected, cur - 1, res);
      }
      expected = cur + 1;
    }
    if (expected <= upper) {
      put(expected, upper, res);
    }
    return res;
  }

  private void put(int lower, int upper, List<String> res) {
    if (lower == upper) {
      res.add(Integer.toString(lower));
    } else {
      res.add(lower + "->" + upper);
    }
  }
}
