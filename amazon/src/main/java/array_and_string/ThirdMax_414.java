package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class ThirdMax_414 {
  public int thirdMax(int[] nums) {
    int fm, sm, tm;
    fm = sm = tm = Integer.MIN_VALUE;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        continue;
      }
      set.add(nums[i]);
      if (nums[i] > fm) {
        tm = sm;
        sm = fm;
        fm = nums[i];
      } else if (nums[i] > sm) {
        tm = sm;
        sm = nums[i];
      } else if (nums[i] > tm) {
        tm = nums[i];
      }
    }
    return set.size() >= 3 ? tm : fm;
  }
}
