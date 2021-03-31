package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class ConsistentString_1684 {
  public int countConsistentStrings(String allowed, String[] words) {
    int count = 0;
    Set<Character> set = getSet(allowed);
    for(String str : words) {
      if(isValid(set, str)) {
        count++;
      }
    }
    return count;
  }

  private Set<Character> getSet(String str) {
    Set<Character> set = new HashSet<>();
    for(char c : str.toCharArray()) {
      set.add(c);
    }
    return set;
  }

  private boolean isValid(Set<Character> set, String word) {
    for(char c : word.toCharArray()) {
      if(!set.contains(c)) {
        return false;
      }
    }
    return true;
  }
}
