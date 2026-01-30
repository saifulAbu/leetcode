package array_and_string;

import java.util.HashMap;

public class NumberOfGoodPairs_1512 {
  public int numIdenticalPairs(int[] nums) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      int curVal = nums[i];
      map.putIfAbsent(curVal, 0);
      int curValPair = map.get(curVal);
      res += curValPair;
      map.put(curVal, curValPair + 1);
    }
    return res;
  }
}
