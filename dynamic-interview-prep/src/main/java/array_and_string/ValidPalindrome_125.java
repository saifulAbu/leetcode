package array_and_string;

public class ValidPalindrome_125 {
  public boolean isPalindrome(String s) {
    int f = s.length() - 1, b = 0;

    while(f > b) {
      while(!Character.isLetterOrDigit(s.charAt(b))) {
        b++;
      }
      while(!Character.isLetterOrDigit(s.charAt(f))) {
        f--;
      }
      if(Character.toLowerCase(s.charAt(b)) != Character.toLowerCase(s.charAt(f))) {
        return false;
      } else {
        b++;
        f--;
      }
    }

    return true;
  }





  public boolean isPalindrome_0(String s) {
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
