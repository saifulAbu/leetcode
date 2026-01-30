package hash;

import java.util.HashMap;
import java.util.LinkedList;

public class TwoSum_III_170 {
  HashMap<Integer, Integer> numCount = new HashMap<>();

  public void add(int num) {
    numCount.put(num, numCount.getOrDefault(num, 0) + 1);
  }

  public boolean find(int value) {
    for(int num0 : numCount.keySet()) {
      int num1 = value - num0;
      int count = numCount.getOrDefault(num1, 0);
      if(count > 0) {
        if(num1 == num0 && count == 1) {
          continue;
        }
        return true;
      }
    }
    return false;
  }
}
