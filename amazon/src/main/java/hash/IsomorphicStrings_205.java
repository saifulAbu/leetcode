package hash;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings_205 {
  public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<>();
    HashMap<Character, Character> revMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char c0 = s.charAt(i), c1 = t.charAt(i);
      map.putIfAbsent(c0, c1);
      revMap.putIfAbsent(c1, c0);
      if(map.get(c0) != c1 || revMap.get(c1) != c0)
        return false;
    }

    return true;
  }
}
