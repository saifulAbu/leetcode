package hash;

import java.util.HashMap;

public class ContainsDuplicate_II_219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> lastIndex = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int curNum = nums[i];
      if(Math.abs(i - lastIndex.getOrDefault(curNum, Integer.MAX_VALUE)) <= k) {
        return true;
      }
      lastIndex.put(curNum, i);
    }
    return false;
  }

  public boolean containsNearbyDuplicate0(int[] nums, int k) {
    HashMap<Integer, Integer> m = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int c = nums[i];
      if(m.containsKey(c)) {
        if(i - m.get(c) <= k) {
          return true;
        }
      }
      m.put(c, i);
    }
    return false;
  }
}
