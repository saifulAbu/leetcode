package array_and_string;

public class XOROperation_1486 {
  public int xorOperation(int n, int start) {
    int xorRes = 0;
    for(int i = 0; i < n; i++) {
      int curNum = start + 2 * i;
      xorRes = xorRes ^ curNum;
    }
    return xorRes;
  }
}
