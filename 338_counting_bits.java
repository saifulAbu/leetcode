package com.company;

public class CountingBits {
  public int[] countBits(int num) {
    int[] result = new int[num+1];
    result[0] = 0;

    int curPower = 0;

    for(curPower = 0; curPower <= Math.ceil(log2(num)); curPower++) {
      int startNumber = (int) Math.pow(2, curPower);
      for(int curNum = startNumber; curNum <= num && (curNum < Math.pow(2, curPower+1)); curNum++) {
        result[curNum] = result[curNum - startNumber] + 1;
      }
    }

    return result;
  }

  private int log2(int x)
  {
    return (int) (Math.log(x) / Math.log(2));
  }

  public static void main(String args[]) {
    CountingBits cb = new CountingBits();
    int[] res = cb.countBits(37);
    return;
  }
}
