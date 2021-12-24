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

  /// new attempt
  int [] calculateSuffixPrefixArr(String str) {
    int [] lsp = new int[str.length()];
    char [] arr = str.toCharArray();
    int len = 0;
    lsp[0] = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[len]) {
        len++;
        lsp[i] = len;
      } else {
        while (len > 0) {
          len = lsp[len - 1];
          if (arr[i] == arr[len]) {
            len++;
            lsp[i] = len;
            break;
          }
        }
        if (len == 0) {
          lsp[i] = 0;
          if (arr[i] == arr[len]) {
            len++;
            lsp[i] = len;
          }
        }
      }
    }
    return lsp;
  }

  private int kmpSearchNew(String h, String n) {
    int [] lsp = calculateSuffixPrefixArr(n);
    int j = 0; //search string index
    int i = 0;
    char [] harr = h.toCharArray();
    char [] narr = n.toCharArray();
    for (; i < harr.length; i++) {
      if (harr[i] == narr[j]) {
        j++;
      } else {
        while (j > 0) {
          j = lsp[j-1];
          if (harr[i] == narr[j]) {
            j++;
            break;
          }
        }
        if (j == 0 && harr[i] == narr[j]) {
          j++;
        }
      }
      if(j == narr.length) {
        break;
      }
    }
    if (j == narr.length) {
      return i - j + 1;
    } else {
      return -1;
    }
  }

}
