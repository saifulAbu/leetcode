package array_and_string;

import java.util.HashMap;

public class LongestPalindrome_409 {
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    boolean sawOdd = false;
    int count = 0;
    for (char key : map.keySet()) {
      int curCount = map.get(key);
      if (curCount % 2 == 1) {
        if(!sawOdd) {
          sawOdd = true;
        } else {
          curCount--; }
      }
      count += curCount;
    }
    return count;
  }
}
