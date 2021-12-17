package array_and_string;

import java.util.LinkedList;
import java.util.List;

public class FindNumbersDisappeared_448 {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int targetIndex = Math.abs(nums[i]) - 1;
      if (nums[targetIndex] > 0) {
        nums[targetIndex] *= -1;
      }
    }

    List<Integer> res = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        res.add(i+1);
      }
    }
    return res;
  }
}
