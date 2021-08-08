package com.company;

public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if(n <= 0) {
      return false;
    }

    while(n > 1) {
      int lastBit = 0;
      lastBit = n & 1;
      if(lastBit == 1) {
        break;
      }
      n = n >> 1;
    }
    if(n > 1) {
      return false;
    }
    return true;
  }

  public static void main(String args[]){
    PowerOfTwo p = new PowerOfTwo();
    boolean res = p.isPowerOfTwo(17);
    return;
  }
}