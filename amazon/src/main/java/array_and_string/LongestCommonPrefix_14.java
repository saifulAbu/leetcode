package array_and_string;

public class LongestCommonPrefix_14 {
  public String longestCommonPrefix(String[] strs) {
    //look at first character of all the strings
    // keey going until you find a mismatch
    int len = 0;
    int minLen = Integer.max();
    for(int i = 0; i < strs.length; i++) {
      minLen = Math.min(strs[i].length(), minLen);
    }
    return strs[0].substring(0, len+1);
  }
  //no idea yet
}
