package array_and_string;

public class CountAndSay_38 {
  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    else {
      String prev = countAndSay(n-1);
      int i = 0;
      String res = "";
      while (i < prev.length()) {
        int count = 1;
        char c = prev.charAt(i);
        i++;
        while (i < prev.length() && prev.charAt(i) == c) {
          count++;
          i++;
        }
        res = res + count + c;
      }
      return res;
    }
  }
}
