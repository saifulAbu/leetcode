package array_and_string;

public class LicenseKeyFormatting_482 {
  public static String licenseKeyFormatting(String s, int k) {
    StringBuilder sb = new StringBuilder(s.length());
    int skipFront = 0;
    while (skipFront < s.length() && s.charAt(skipFront) == '-') {
      skipFront++;
    }
    int i = s.length() - 1;
    while (i >= skipFront) {
      int j = 0;
      while (j < k && i >= skipFront) {
        char ch = s.charAt(i--);
        if (ch == '-') {
          continue;
        }
        sb.append(Character.toUpperCase(ch));
        j++;
      }
      if (i >= skipFront) {
        sb.append('-');
      }
    }
    return sb.reverse().toString();
  }

  public static void main(String args[]) {
    System.out.println(licenseKeyFormatting("--22-5g-3-J", 2));
  }
}
