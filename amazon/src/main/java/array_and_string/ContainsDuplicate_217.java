package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int num : nums) {
      if (set.contains(num)) {
        return false;
      }
      set.add(num);
    }
    return true;
  }
}
