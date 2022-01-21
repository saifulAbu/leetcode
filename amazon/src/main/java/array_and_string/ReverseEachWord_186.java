package array_and_string;

public class ReverseEachWord_186 {
  public void reverseWords(char[] s) {
    int n = s.length;
    //reverse the whole string
    reverse(s, 0, n-1);
    //reverse individual strings
    int start = 0;
    while (start < n) {
      int end = start + 1;
      while (end < n && s[end] != ' ') {
        end++;
      }
      reverse(s, start, end-1);
      start = end + 1;
    }
  }

  private void reverse(char[] s, int start, int end) {
    while (start < end) {
      char t = s[start];
      s[start] = s[end];
      s[end] = t;
      start++;
      end--;
    }
  }

}
