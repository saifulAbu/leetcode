package alpha_rep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_3 {

  public int lengthOfLongestSubstring(String s) {
    /*
    * s     i
    * 0 1 2 3 4
    * a b c d a
    *
    * we will maintain an invariant such that the s pointer and i pointer won't have any duplicates.
    * we will maintain a map that will hold the most recent index of a character
    * lets for i = 3, s will be at 0 and the map will be the following
    * a -> 0, b -> 1, c -> 2, d -> 3
    * length of non repeated character sub string = i - s + 1 = 3 - 0 + 1 = 4
    * when we move i to the right, i = 4, we find a. prev index of of a is 0. to maintain the invariant now, we need to move the s pointer to one step.
    * at each step, we will recalculate the current substring length and update the maxLen accordingly
    *
    * below we mention the s pointer as startNonRepeatIndex.
    * */

    int startNonRepeatIndex = 0;
    int maxLen = 0;
    Map<Character, Integer> latestIndexMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      int curCharPrevIndex = latestIndexMap.getOrDefault(curChar, -1);
      if(curCharPrevIndex >= startNonRepeatIndex) {
        startNonRepeatIndex = curCharPrevIndex + 1;
      }
      latestIndexMap.put(curChar, i);
      maxLen = Math.max(maxLen, i - startNonRepeatIndex + 1);
    }

    return maxLen;
  }

  public int lengthOfLongestSubstring0(String s) {
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
