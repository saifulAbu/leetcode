package array_and_string;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum_1 {
  public static void main(String args[]) {

  }

  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap();

    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for(int i = 0; i < nums.length; i++) {
      int num0 = nums[i];
      int num1 = target - num0;
      if(map.containsKey(num1)) {
        res[0] = i;
        res[1] = map.get(num1);
      }
    }

    return res;
  }
}
