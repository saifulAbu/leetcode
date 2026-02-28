package alpha_rep;

public class LongestRepeatingChars_424 {

  public int characterReplacement_o_n(String str, int k) {
    int len = str.length();
    int maxLen = 0;
    int [] freqs = new int[26];
    int maxFreq = 0;
    int s = 0;
    for(int e = 0; e < len; e++) {
      int curFreq = ++freqs[str.charAt(e) - 'A'];
      if(curFreq > maxFreq) {
        maxFreq = curFreq;
      }
      int need = (e - s + 1 - maxFreq);
      if(need <= k) {
        int curLen = e - s + 1;
        if(curLen > maxLen) {
          maxLen = curLen;
        }
      } else {
        freqs[str.charAt(s) - 'A']--;
        s++;
      }
    }
    return maxLen;
  }

  public int characterReplacement_o_n_2(String str, int k) {
    int len = str.length();
    int maxLen = 0;
    for(int s = 0; s < len; s++) {
      int [] freqs = new int[26];
      int maxFreq = 0;
      for(int e = s; e < len; e++) {
        int curFreq = ++freqs[str.charAt(e) - 'A'];
        if(curFreq > maxFreq) {
          maxFreq = curFreq;
        }
        int need = (e - s + 1 - maxFreq);
        if(need <= k) {
          int curLen = e - s + 1;
          if(curLen > maxLen) {
            maxLen = curLen;
          }
        }
      }
    }
    return maxLen;
  }

  public int characterReplacement_o_n_3(String str, int k) {
    int len = str.length();
    int maxLen = 0;
    for(int s = 0; s < len; s++) {
      for(int e = s; e < len; e++) {
        int need = replacementsNeeded(s, e, str);
        if(need <= k) {
          int curLen = e - s + 1;
          if(curLen > maxLen) {
            maxLen = curLen;
          }
        }
      }
    }
    return maxLen;
  }

  private int replacementsNeeded(int s, int e, String str) {
    int [] freqs = new int[26];
    for(int i = s; i <= e; i++) {
      freqs[str.charAt(i) - 'A']++;
    }

    int maxFreq = 0;
    for(int i = 0; i < freqs.length; i++) {
      if(freqs[i] > maxFreq) {
        maxFreq = freqs[i];
      }
    }

    return (e - s + 1 - maxFreq);
  }
}
