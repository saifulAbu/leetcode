package array_and_string;

public class ToLowerCase_709 {
  public String toLowerCase(String str) {
    char [] input = str.toCharArray();

    for (int i = 0; i < input.length; i++) {
      if (isUpperCase(input[i])) {
        input[i] = convertLower(input[i]);
      }
    }

    return new String(input);
  }

  private char convertLower(char c) {
    return (char) ('a' + (c - 'A'));
  }

  private boolean isUpperCase(char c) {
    int offset = c - 'A';
    if (offset >= 0 && offset <= 25) {
      return true;
    }
    return false;
  }

  public static void main(String [] args) {
    ToLowerCase_709 t = new ToLowerCase_709();
    t.toLowerCase("abc");
  }

}
