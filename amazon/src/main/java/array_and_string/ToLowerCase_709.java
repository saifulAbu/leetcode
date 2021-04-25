package array_and_string;

public class ToLowerCase_709 {
  public String toLowerCase(String str) {
    System.out.println(isUpperCase('A'));
    System.out.println(isUpperCase('Z'));
    System.out.println(isUpperCase('a'));
    System.out.println(isUpperCase('c'));
    System.out.println(isUpperCase('1'));
    return "";
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
