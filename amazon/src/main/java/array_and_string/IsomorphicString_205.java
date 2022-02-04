package array_and_string;

import java.util.HashMap;

public class IsomorphicString_205 {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<>();
    HashMap<Character, Character> val = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char k = s.charAt(i);
      char v = t.charAt(i);
      map.putIfAbsent(k, v);
      val.putIfAbsent(v, k);
      if (map.get(k) != v || val.get(v) != k) {
        return false;
      }
    }
    return true;
  }
}
