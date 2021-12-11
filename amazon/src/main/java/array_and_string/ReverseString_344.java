package array_and_string;

public class ReverseString_344 {
  public void reverseString(char[] s) {
    for (int i = 0; i < (s.length - 1) / 2; i++ ) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }

  public static void main(String[] args) {
    System.out.println(-10 % 3);
  }
}
