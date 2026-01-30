package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepChar_3 {

  public int lengthOfLongestSubstring(String s) {
    int maxLen = 0;
    int startIndex = 0;
    HashMap<Character, Integer> seenCharMap = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);
      int prevIndex = seenCharMap.getOrDefault(curChar, -1);

      // d a b c d a
      // 0 1 2 3 4 5
      // startIndex = 1
      if(prevIndex >= startIndex) {
        // i = 5, prevIndex = 1
        int prevLen = i - startIndex; // substring length excluding current character
        maxLen = (prevLen > maxLen) ? prevLen : maxLen;
        // startIndex = 2
        startIndex = prevIndex + 1;
      }

      int curLen = i - startIndex + 1;
      maxLen = curLen > maxLen ? curLen : maxLen;
      seenCharMap.put(curChar, i);
    }

    return maxLen;
  }

  public int lengthOfLongestSubstring0(String s) {
    int maxLen = 0;
    int start = 0;
    int end = 0;
    char arr[] = s.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();

    while(end < arr.length) {
      char cur = arr[end++];
      if(map.containsKey(cur)) {
        int newStart = map.get(cur) + 1;
        while(start < newStart) {
          char charToRemove =  arr[start++];
          map.remove(charToRemove);
        }
      }
      map.put(cur, end-1);
      if(end - start > maxLen) {
        maxLen = end - start;
      }
    }
    return maxLen;
  }
}
