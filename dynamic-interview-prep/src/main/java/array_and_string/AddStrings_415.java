package array_and_string;

public class AddStrings_415 {
  public String addStrings(String num0, String num1) {
    StringBuilder sb = new StringBuilder();
    int len0 = num0.length(), len1 = num1.length();
    num0 = (new StringBuilder(num0)).reverse().toString();
    num1 = (new StringBuilder(num1)).reverse().toString();
    int c = 0;
    for (int i = 0; i < Math.max(len0, len1); i++) {
      int d0, d1, s;
      d0 = len0 > i ? num0.charAt(i) - '0' : 0;
      d1 = len1 > i ? num1.charAt(i) - '0' : 0;
      s = d0 + d1 + c;
      c = s / 10;
      sb.append(s%10);
    }
    if (c == 1) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }
}
