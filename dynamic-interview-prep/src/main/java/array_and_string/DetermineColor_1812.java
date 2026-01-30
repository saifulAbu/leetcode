package array_and_string;

public class DetermineColor_1812 {
  public boolean squareIsWhite(String coordinates) {
    char [] carr = coordinates.toCharArray();
    int steps = carr[0] - 'a' + carr[1] - '1';
    if (steps % 2 == 0) {
      return false;
    }
    return true;
  }
}
