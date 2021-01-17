package array_and_string;

import java.util.HashMap;

public class LongestSubstringWithoutRepChar_3 {
  public int lengthOfLongestSubstring(String s) {
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

  public static void main(String args[]) {
    LongestSubstringWithoutRepChar_3 l = new LongestSubstringWithoutRepChar_3();
    System.out.println(l.lengthOfLongestSubstring("a"));
  }
}
