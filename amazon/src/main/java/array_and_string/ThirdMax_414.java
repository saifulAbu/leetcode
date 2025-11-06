package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class ThirdMax_414 {

  public int thirdMax(int[] nums) {
    // this array will hold the distinct maxes in descending order
    int [] max = new int[3];
    max[0] = Integer.MIN_VALUE;
    max[1] = Integer.MIN_VALUE;
    max[2] = Integer.MIN_VALUE;
    boolean minSeen = false;

    for(int num : nums) {
      if(num == Integer.MIN_VALUE) {
        minSeen = true;
      }
      if(num > max[0]) {
        max[2] = max[1];
        max[1] = max[0];
        max[0] = num;
      } else if (max[0] > num && num > max[1]) {
        max[2] = max[1];
        max[1] = num;
      } else if (max[1] > num && num > max[2]) {
        max[2] = num;
      }
    }

    if(minSeen) {
      if(max[1] != Integer.MIN_VALUE) {
        return max[2];
      }
    } else {
      if(max[2] != Integer.MIN_VALUE) {
        return max[2];
      }
    }

    return max[0];
  }

  public int thirdMax0(int[] nums) {
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
