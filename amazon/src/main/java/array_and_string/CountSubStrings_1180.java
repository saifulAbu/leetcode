package array_and_string;

public class CountSubStrings_1180 {
  public int countLetters(String s) {
    int curLen = 0;
    int res = 0;
    char curChar = s.charAt(0);
    for (int i = 0; i < s.length(); i++) {
      if (curChar == s.charAt(i)) {
        curLen++;
      } else {
        res += ((curLen) * (curLen + 1) / 2);
        curChar = s.charAt(i);
        curLen = 1;
      }
    }
    return res;
  }
}
