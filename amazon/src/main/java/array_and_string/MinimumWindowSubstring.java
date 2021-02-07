package array_and_string;

import java.util.HashMap;

public class MinimumWindowSubstring {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> tMap = new HashMap<>();
    for(Character c : t.toCharArray()) {
      tMap.putIfAbsent(c, 0);
      tMap.put(c, tMap.get(c) + 1);
    }
    int charTypeInT = tMap.size();

    HashMap<Character, Integer> movingSMap = new HashMap<>();
    int charTypeMatchedT = 0;
    int tail, head;
    tail = 0;
    head = 0;

    while(head < s.length()) {
      while(tail < head && charTypeMatchedT >= charTypeInT) {
        char c = s.charAt(tail);
        if(tMap.get(c) != null && movingSMap.get(c) != null && tMap.get(c) == movingSMap.get(c)) {
          charTypeMatchedT--;
        }
        movingSMap.put(c, movingSMap.get(c) - 1);
        tail++;
      }
      char c = s.charAt(head);
      if(tMap.get(c) != null) {
        movingSMap.putIfAbsent(c, 0);
        movingSMap.put(c, movingSMap.get(c) + 1);
        if(movingSMap.get(c) == tMap.get(c)) {
          charTypeMatchedT++;
        }
      }
      if(charTypeMatchedT == charTypeInT) {
        System.out.println(s.substring(tail, head));
      }
      head++;
    }



    return "";
  }

  public static void main(String[] args) {
    String s = "abcda";
    String t = "ad";
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    m.minWindow(s, t);
  }
}
