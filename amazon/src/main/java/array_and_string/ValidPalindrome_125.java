package array_and_string;

public class ValidPalindrome_125 {
  public boolean isPalindrome(String s) {
    int front = 0;
    int back = s.length() - 1;

    while (front < back) {
      if (!Character.isLetterOrDigit(s.charAt(front))) {
        front++;
      } else if (!Character.isLetterOrDigit(s.charAt(back))) {
        back--;
      } else if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) {
        return false;
      } else {
        front++;
        back--;
      }
    }
    return true;
  }
}
