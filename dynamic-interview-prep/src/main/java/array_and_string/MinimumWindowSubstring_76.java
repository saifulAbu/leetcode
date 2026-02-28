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

  public String minWindow_bruteForce(String s, String t) {
    if(t.length() > s.length()) {
      return "";
    } else if(s.equals(t)) {
      return s;
    }
    HashMap<Character, Integer> freqT = new HashMap<>();

    for(char ch : t.toCharArray()) {
      freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
    }

    int min0 = 0, min1 = s.length() - 1;
    boolean found = false;

    for(int i = 0; i <= (s.length() - t.length()); i++) {
      HashMap<Character, Integer> targetFreq = new HashMap<>(freqT);
      int charToMatch = targetFreq.size();
      for(int j = i; j < s.length(); j++) {
        char cur = s.charAt(j);
        if(targetFreq.containsKey(cur)) {
          targetFreq.put(cur, targetFreq.get(cur) - 1);
          if(targetFreq.get(cur) == 0) {
            charToMatch--;
          }
          if(charToMatch == 0) {
            found = true;
            if(min1 - min0 > j - i) {
              min1 = j;
              min0 = i;
            }
            break;
          }
        }
      }
    }

    if(found) {
      return s.substring(min0, min1 + 1);
    } else {
      return "";
    }
  }

  public String minWindow_drona(String s, String t) {
    HashMap<Character, Integer> need = new HashMap<>();
    for(int i = 0; i < t.length(); i++) {
      char curChar = t.charAt(i);
      need.put(curChar, need.getOrDefault(curChar, 0) + 1);
    }
    int uniCharsNeeded = need.size();

    HashMap<Character, Integer> have = new HashMap<>();
    int uniCharsHave = 0;
    int minLen = Integer.MAX_VALUE, minStart = 0;

    int b = 0;
    for(int f = 0; f <s.length(); f++) {
      char in = s.charAt(f);
      have.put(in, have.getOrDefault(in, 0) + 1);

      if(need.containsKey(in) && need.get(in) == have.get(in)) {
        uniCharsHave++;
      }

      while(uniCharsHave == uniCharsNeeded) {
        int curLen = f - b + 1;
        if(curLen < minLen) {
          minLen = curLen;
          minStart = b;
        }

        char out = s.charAt(b);
        have.put(out, have.get(out) - 1);

        if(need.containsKey(out) && need.get(out) > have.get(out)) {
          uniCharsHave--;
        }

        b++;
      }
    }
    return minLen == Integer.MAX_VALUE ? "" :  s.substring(minStart, minStart + minLen);
  }
}
