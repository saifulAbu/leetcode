package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_3 {
  public int lengthOfLongestSubstring(String s) {
    int startNonRepeat = 0;
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int prevIndex = -1;
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        prevIndex = map.get(ch);
      }
      if (prevIndex >= startNonRepeat) {
        startNonRepeat = prevIndex + 1;
      }
      map.put(ch, i);
      max = Math.max(max, i - startNonRepeat + 1);
    }
    return max;
  }
}
