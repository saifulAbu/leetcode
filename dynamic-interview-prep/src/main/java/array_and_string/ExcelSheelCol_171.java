package array_and_string;

public class ExcelSheelCol_171 {
  public int titleToNumber(String columnTitle) {
    int mul = 1;
    int col = 0;
    for (int i = columnTitle.length() - 1; i >= 0; i--) {
      int intVal = columnTitle.charAt(i) - 'A' + 1;
      col += mul * intVal;
      mul *= 26;
    }
    return col;
  }
}
