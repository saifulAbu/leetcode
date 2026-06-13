package alpha_rep;

public class LongestPalindrome_5 {
  public String longestPalindrome_drona(String s) {
    int maxLen = 0, maxStart = -1;
    for(int i = 0; i < s.length(); i++) {
      int oddLen = expand(s, i-1, i+1);
      if(oddLen > maxLen) {
        maxStart = i - oddLen / 2;
        maxLen = oddLen;
      }

      int evenLen = expand(s, i, i+1);
      if(evenLen > maxLen) {
        maxStart = i - (evenLen / 2) + 1;
        maxLen = evenLen;
      }
    }

    return s.substring(maxStart, maxStart + maxLen);
  }

  private int expand(String s, int l, int r) {
    int n = s.length();
    while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }

  public String longestPalindrome_0410(String s) {
    int maxLen = 0;
    int maxStart = 0;
    for(int i = 0; i < s.length(); i++) {
      int curLen = expand_0410(s, i, i+1);
      if(curLen > maxLen) {
        maxLen = curLen;
        maxStart = i - maxLen / 2 + 1;

      }

      curLen = expand_0410(s, i, i);
      if(curLen > maxLen) {
        maxLen = curLen;
        maxStart = i - maxLen/2;
      }
    }
    return s.substring(maxStart, maxStart + maxLen);
  }

  private int expand_0410(String s, int i, int j) {
    while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return j - i - 1;
  }

  public String longestPalindrome0531(String s) {
    int maxStart = 0;
    int maxLen = 0;
    int n = s.length();
    for(int i = 0; i < n; i++) {
      int curLen = Math.max(expand0531(i, i, s), expand0531(i, i+1, s));

      if(curLen > maxLen) {
        maxStart = i - (curLen+1) / 2 + 1;
        maxLen = curLen;
      }
    }

    return s.substring(maxStart, maxStart + maxLen);
  }

  private int expand0531(int i, int j, String s) {
    while(i >= 0 && j < s.length()) {
      if(s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
      } else {
        break;
      }
    }
    return j - i - 1;
  }

}
