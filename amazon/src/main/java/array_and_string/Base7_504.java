package array_and_string;

public class Base7_504 {
  public String convertToBase7(int num) {
    if(num == 0) return "0";
    String res = "";
    int sign = (num < 0) ? -1 : 1;
    num = Math.abs(num);
    while (num > 0) {
      res = (num % 7) + res;
      num = num / 7;
    }
    return sign == -1? "-" + res : res;
  }
}
