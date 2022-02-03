package array_and_string;

import java.util.HashMap;

public class ExcelSheet_168 {
  static public String convertToTitle(int columnNumber) {
    HashMap<Integer, Character> map = new HashMap<>();
    char cur = 'Z';
    map.put(0, cur);
    cur = 'A';
    for (int i = 1; i < 26; i++) {
      map.put(i, cur);
      cur = (char) ((int)cur + 1);
    }
    StringBuilder sb = new StringBuilder();
    while (columnNumber > 0) {
      int rem = columnNumber % 26;
      sb.append(map.get(rem));
      columnNumber /= 26;
    }
    return sb.reverse().toString();
  }

  public static void main(String args[]) {
    convertToTitle(78);
  }
}
