package hash;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings_205 {

  /*
  * s = A A A
  * t = B B B
  * i = 0 1 2
  *
  * i = 0  map = [], values = []
  * i = 1  map = [B =>A], values = [A]
  * i = 2, all key = B, value = A, maps still valid
  * s = A A A
  * t = B B C
  * i = 0 1 2
  * i = 2 [B => A], values = [A], key = C, value = A. value already used. so not possible
  *
  * */
  public boolean isIsomorphic(String s, String t) {
    if(s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Character> map = new HashMap<>();
    HashSet<Character> values = new HashSet<>();

    for(int i = 0; i < s.length(); i++) {
      char key = t.charAt(i);
      char value = s.charAt(i);

      if(map.containsKey(key)) {
        if(map.get(key) != value) {
          return false;
        }
      } else {
        if(values.contains(value)) {
          return false;
        }
        map.put(key, value);
        values.add(value);
      }
    }
    return true;
  }

  public boolean isIsomorphic0(String s, String t) {
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
