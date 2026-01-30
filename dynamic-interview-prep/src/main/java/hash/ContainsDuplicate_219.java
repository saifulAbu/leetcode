package hash;

import java.util.HashMap;

public class ContainsDuplicate_219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int index = map.getOrDefault(nums[i], (-k-1));
      if (i - index <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
