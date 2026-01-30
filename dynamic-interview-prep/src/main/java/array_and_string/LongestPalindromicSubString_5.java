package array_and_string;

public class LongestPalindromicSubString_5 {
  public String longestPalindrome(String s) {
    char [] arr = s.toCharArray();
    int start = 0, maxLen = 0;
    for (int i = 0; i < arr.length; i++) {
      int len = expandAroundCenter(arr,i-1, i+1);
      if (maxLen < len) {
        maxLen = len;
        start = i - len / 2;
      }
      len = expandAroundCenter(arr,i, i+1);
      if (maxLen < len) {
        maxLen = len;
        start = i - len / 2 + 1;
      }
    }
    return s.substring(start, start + maxLen);
  }

  int expandAroundCenter(char[] str, int left, int right) {
    while (left >= 0 && right < str.length && str[left] == str[right]) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
