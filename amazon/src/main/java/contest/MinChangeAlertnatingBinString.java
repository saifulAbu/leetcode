package contest;

import array_and_string.MinimumWindowSubstring;

public class MinChangeAlertnatingBinString {
  public int minOperations(String s) {
    return Math.min(getFlips(s, 0), getFlips(s, 1));
  }

  private int getFlips(String s, int firstBit) {
    int curBit = firstBit;
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
      char curC = s.charAt(i);
      if((curC - '0') != curBit){
        count++;
      }
      curBit = 1 ^ curBit;
    }
    return count;
  }

  public static void main(String args[]) {
    String s1 = "0";
    MinChangeAlertnatingBinString m = new MinChangeAlertnatingBinString();
    System.out.println(m.minOperations(s1));
  }
}
