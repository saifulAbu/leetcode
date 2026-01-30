package array_and_string;

public class GenerateString_1374 {
  public String generateTheString(int n) {
    if (n % 2 == 0) {
      return printChar(n-1) + "b";
    }
    return printChar(n);
  }

  private String printChar(int n) {
    String s = "";
    for(int i = 0; i < n; i++) {
      s = s + "a";
    }
    return s;
  }
}
