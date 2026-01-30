package array_and_string;

public class LongerContinuous_1869 {
  public boolean checkZeroOnes(String s) {
    int max1 = Integer.MIN_VALUE;
    int cursize1 = 0;
    int max0 = Integer.MIN_VALUE;
    int cursize0 = 0;
    for(char c : s.toCharArray()) {
      if (c == '1') {
        cursize1++;
        cursize0 = 0;
      } else {
        cursize1 = 0;
        cursize0++;
      }
      if (cursize1 > max1) {
        max1 = cursize1;
      }
      if (cursize0 > max0) {
        max0 = cursize0;
      }
    }
    return max1 > max0;
  }
}
