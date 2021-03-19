package array_and_string;

import java.util.HashMap;

public class MinimumWindowSubstring_76_Wrong {
  public String minWindow(String s, String t) {
    if(s.length() == 0 || t.length() == 0 || (s.length() < t.length())) {
      return "";
    }
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
    int resHead = Integer.MAX_VALUE;
    int resTail = 0;

    while(head < s.length()) {
      char c = s.charAt(head);
      if(tMap.get(c) != null) {
        movingSMap.putIfAbsent(c, 0);
        movingSMap.put(c, movingSMap.get(c) + 1);
        if(movingSMap.get(c) == tMap.get(c)) {
          charTypeMatchedT++;
        }
      }

      while(tail <= head && charTypeMatchedT >= charTypeInT) {
        if(head - tail < (resHead - resTail)) {
          resHead = head;
          resTail = tail;
        }
        c = s.charAt(tail);
        if(tMap.get(c) != null) {
          if (tMap.get(c) == movingSMap.get(c)) {
            charTypeMatchedT--;
          }
          movingSMap.put(c, movingSMap.get(c) - 1);
        }
        tail++;
      }
      head++;

    }

    if(resHead == Integer.MAX_VALUE) {
      return "";
    }
    return s.substring(resTail, resHead+1);
  }

  public static void main(String[] args) {
    String s = "a";
    String t = "b";
    MinimumWindowSubstring_76_Wrong m = new MinimumWindowSubstring_76_Wrong();
    String res = m.minWindow(s, t);
    System.out.println(res);
  }
}
