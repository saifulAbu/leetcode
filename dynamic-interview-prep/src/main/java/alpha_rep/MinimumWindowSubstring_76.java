package alpha_rep;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

  public String minWindow_drona(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    // Frequency map for characters in t
    Map<Character, Integer> target = new HashMap<>();
    for (char c : t.toCharArray()) {
      target.put(c, target.getOrDefault(c, 0) + 1);
    }

    // Sliding window frequency map
    Map<Character, Integer> window = new HashMap<>();

    int required = target.size();   // number of distinct chars we must match
    int formed = 0;                 // number of chars that currently match required freq

    int l = 0, r = 0;
    int bestLen = Integer.MAX_VALUE;
    int bestStart = 0;

    while (r < s.length()) {
      char c = s.charAt(r);
      window.put(c, window.getOrDefault(c, 0) + 1);

      // If this character's frequency matches the target's frequency, increment formed
      if (target.containsKey(c) &&
              window.get(c).intValue() == target.get(c).intValue()) {
        formed++;
      }

      // Try to shrink the window while it's valid
      while (l <= r && formed == required) {
        int windowLen = r - l + 1;
        if (windowLen < bestLen) {
          bestLen = windowLen;
          bestStart = l;
        }

        char leftChar = s.charAt(l);
        window.put(leftChar, window.get(leftChar) - 1);

        // If removing this char breaks the validity, decrement formed
        if (target.containsKey(leftChar) &&
                window.get(leftChar).intValue() < target.get(leftChar).intValue()) {
          formed--;
        }

        l++;
      }

      r++;
    }

    return bestLen == Integer.MAX_VALUE
            ? ""
            : s.substring(bestStart, bestStart + bestLen);
  }


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

  public String minWindow_0528(String s, String t) {
    if (t.length() > s.length()) return "";

    HashMap<Character, Integer> target = new HashMap<>();
    for (char ch : t.toCharArray()) {
      target.put(ch, target.getOrDefault(ch, 0) + 1);
    }

    int need = target.size();
    int formed = 0;

    HashMap<Character, Integer> window = new HashMap<>();
    int b = 0;
    int minLen = Integer.MAX_VALUE;
    int minStart = 0;

    for (int f = 0; f < s.length(); f++) {
      char ch = s.charAt(f);
      window.put(ch, window.getOrDefault(ch, 0) + 1);

      if (target.containsKey(ch) && window.get(ch).intValue() == target.get(ch).intValue()) {
        formed++;
      }

      while (formed == need) {
        if (f - b + 1 < minLen) {
          minLen = f - b + 1;
          minStart = b;
        }

        char out = s.charAt(b);
        if (target.containsKey(out) && window.get(out).intValue() == target.get(out).intValue()) {
          formed--;
        }
        window.put(out, window.get(out) - 1);
        b++;
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
  }

}
