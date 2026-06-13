package alpha_rep;

public class ValidPalindrome_125 {

  public boolean isPalindrome_drona(String s) {
    int l = 0, r = s.length() - 1;

    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
        return false;
      }

      l++;
      r--;
    }

    return true;
  }



  public boolean isPalindrome_1(String s) {
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

  public boolean isPalindrome_0527(String s) {
    char[] charArr = s.toCharArray();
    int n = s.length();
    int f = 0;
    int b = n - 1;

    while (f < b) {

      while (f < b && !Character.isLetterOrDigit(charArr[f])) {
        f++;
      }

      while (f < b && !Character.isLetterOrDigit(charArr[b])) {
        b--;
      }

      if (Character.toLowerCase(charArr[f]) != Character.toLowerCase(charArr[b])) {
        return false;
      }

      f++;
      b--;
    }

    return true;
  }

}
