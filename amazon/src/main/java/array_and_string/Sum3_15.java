package array_and_string;

import java.util.*;

public class Sum3_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    if (nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);
    //special case 3 zeros
    int zeroCount = 0;
    for (int i : nums) {
      if (i == 0) {
        zeroCount++;
      }
    }
    if (zeroCount >= 3) {
      res.add(Arrays.asList(0, 0, 0));
    }
    Map<Integer, Integer> map = new HashMap<>();
    //add number to map if negative latest index, if positive earliest
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        map.put(nums[i], i);
      } else {
        if (!map.containsKey(nums[i])) {
          map.put(nums[i], i);
        }
      }
    }

    int low = 0;
    int hi = nums.length - 1;
    while (low < hi) {
      int sum = nums[low] + nums[hi];
      int target = sum * -1 ;
      if (map.containsKey(target)) {
        int targetIndex = map.get(target);
        if (targetIndex != low && targetIndex != hi) {
          int a = nums[low];
          int b = nums[targetIndex];
          int c = nums[hi];
          List<Integer> list = Arrays.asList(a, b, c);
          res.add(list);
          while (nums[low] == a) {
            low++;
          }
          while (nums[hi] == c) {
            hi--;
          }
          continue;
        }
      }
      if (sum < 0) {
        low++;
      } else {
        hi--;
      }
    }
    return res;
  }
}
