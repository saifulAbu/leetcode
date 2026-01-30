package array_and_string;

public class PalindromeNumber_9 {
  public boolean isPalindrome(int x) {
    int orig = x;
    int rev = 0;

    if(x < 0) {
      return false;
    }

    while (orig > 0) {
      int curd = orig % 10;
      orig = orig / 10;
      if(
          (rev > Integer.MAX_VALUE / 10) ||
          (rev == Integer.MAX_VALUE / 10) && (curd > Integer.MAX_VALUE % 10)
      ) {
        return  false;
      }
      rev = rev * 10 + curd;
    }

    if (rev == x) {
      return  true;
    }
    return false;
  }
}
