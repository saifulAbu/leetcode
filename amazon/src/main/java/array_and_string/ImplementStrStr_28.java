package array_and_string;

public class ImplementStrStr_28 {
  public int strStr(String haystack, String needle) {
    if(needle.equals("")) {
      return 0;
    }
    if(haystack.equals("")) {
      return -1;
    }
    if(haystack.length() < needle.length()) {
      return -1;
    }
    return kmpSearch(haystack, needle);

  }

  private int kmpSearch(String h, String n) {
    int [] lps = computeLPSArr(n);
    int j = 0;
    int i = 0;
    while (j < h.length()) {
      if (h.charAt(j) == n.charAt(i)) {
        i++;
        j++;
      } else {
        if (i > 0) {
          i = lps[i-1];
        } else {
          j++;
        }
      }
      if(i == n.length()) {
        return j - n.length();
      }

    }
    return -1;
  }

  private int[] computeLPSArr (String str) {
    int [] lps = new int[str.length()];
    lps[0] = 0;
    int i = 1;
    int j = 0;
    while(i < str.length()) {
      if (str.charAt(i) == str.charAt(j)) {
        j++;
        lps[i] = j;
        i++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
}
