package hash;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int num : nums) {
      if(set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  public boolean containsDuplicate0(int[] nums) {
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
