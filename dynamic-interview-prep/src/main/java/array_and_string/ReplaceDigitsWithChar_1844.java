package array_and_string;

public class ReplaceDigitsWithChar_1844 {
  public String replaceDigits(String s) {
    char [] charr = s.toCharArray();

    for (int i = 1; i < charr.length; i += 2) {
      charr[i] = (char) (charr[i-1] + charr[i]);
    }
    return new String(charr);
  }
}
