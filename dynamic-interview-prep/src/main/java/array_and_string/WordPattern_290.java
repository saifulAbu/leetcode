package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern_290 {
  public boolean wordPattern(String pattern, String s) {
    String splitArr[] = s.split(" ");
    if (pattern.length()!=splitArr.length) {
      return false;
    }
    HashMap<Character, String> db = new HashMap<>();
    HashSet<String> seen = new HashSet<>();
    for (int i = 0; i < splitArr.length; i++) {
      char ch = pattern.charAt(i);
      String curWord = splitArr[i];
      if (!db.containsKey(ch) && seen.contains(curWord)) {
        return false;
      }
      db.putIfAbsent(ch, curWord);
      seen.add(curWord);
      if (!db.get(ch).equals(curWord)) {
        return false;
      }
    }
    return true;
  }
}
