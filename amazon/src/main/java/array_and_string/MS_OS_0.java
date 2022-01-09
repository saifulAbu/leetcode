package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class MS_OS_0 {
  public boolean solution(int[] A) {
    // write your code in Java SE 8
    if (A.length < 2) {
      return false;
    }
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int num : A) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    for (int freq : freqMap.values()) {
      //if any number occurs odd number of times, it's not possible to form a pair
      if (freq % 2 != 0) {
        return false;
      }
    }

    return true;
  }
  public static void main(String args []) {
      int[] a = {1};
      MS_OS_0 sol = new MS_OS_0();
      System.out.println(sol.solution(a));
      System.out.println(Integer.MAX_VALUE);

  }
}
