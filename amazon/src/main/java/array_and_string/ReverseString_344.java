package array_and_string;

public class ReverseString_344 {
  public void reverseString(char[] s) {
    int l = 0;
    int r = s.length -1 ;
    while(l < r) {
      char t = s[l];
      s[l] = s[r];
      s[r] = t;
    }
    l++;
    r--;
  }

  public void reverseString0(char[] s) {
    for (int i = 0; i < (s.length ) / 2; i++ ) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }

  public static void main(String[] args) {
    System.out.println(-10 % 3);
  }
}
