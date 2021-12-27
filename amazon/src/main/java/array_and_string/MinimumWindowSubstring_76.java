package array_and_string;

import java.util.HashMap;

public class MinimumWindowSubstring_76 {
  static public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    HashMap<Character, Integer> target = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      int cnt = target.getOrDefault(ch, 0);
      target.put(ch, cnt + 1);
    }
    HashMap<Character, Integer> src = new HashMap<>();
    int l = 0, r = 0;
    int formed = 0;
    int optimumStrt = 0;
    int optimumLen = -1;
    for (; r < s.length(); r++) {
      char ch = s.charAt(r);
      int cnt = src.getOrDefault(ch, 0);
      src.put(ch, cnt + 1);
      if (src.get(ch).intValue() == target.getOrDefault(ch, 0).intValue()) {
        formed++;
      }
      while (l <= r && formed == target.size()) {
        char lch = s.charAt(l);
        int lcnt = src.getOrDefault(lch, 0);
        int curLen = r - l + 1;
        if (optimumLen == - 1 || curLen < optimumLen) {
          optimumStrt = l;
          optimumLen = curLen;
        }
        if (target.getOrDefault(lch, 0).intValue() == src.get(lch).intValue()) {
          formed--;
        }
        src.put(lch, lcnt - 1);

        l++;
      }
    }
    if(optimumLen == -1) {
      return "";
    } else {
      return s.substring(optimumStrt, optimumLen + optimumStrt);
    }
  }

  public static void main(String args[]) {
    System.out.println(minWindow("AABC", "AB"));
    HashMap<Integer, Integer> h1 = new HashMap<>();
    HashMap<Integer, Integer> h2 = new HashMap<>();

    h1.put(1, 1000);
    h2.put(1, 1000);

    String a = h1.get(1) == h2.get(1) ? "Yes" : "NO";

    System.out.println(a);
  }


}
