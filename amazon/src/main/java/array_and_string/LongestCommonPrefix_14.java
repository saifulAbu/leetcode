package array_and_string;

public class LongestCommonPrefix_14 {
  public String longestCommonPrefix(String[] strs) {
    //look at first character of all the strings
    // keey going until you find a mismatch
    if(strs.length == 0) {
      return "";
    }

    int minLen = Integer.MAX_VALUE;
    for(int i = 0; i < strs.length; i++) {
      minLen = Math.min(strs[i].length(), minLen);
    }

    int len = 0;
    for(; len < minLen; len++) {
      char cur = strs[0].charAt(len);
      boolean mismatch = false;
      for(int i = 0; i < strs.length; i++) {
        String str = strs[i];
        if(str.charAt(len) != cur) {
          mismatch = true;
        }
      }
      if(mismatch) {
        break;
      }
    }
    return strs[0].substring(0, len+1);
  }
  //no idea yet
}
