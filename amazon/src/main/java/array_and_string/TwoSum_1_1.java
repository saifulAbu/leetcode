package array_and_string;

//https://leetcode.com/problems/two-sum/
import java.util.HashMap;

public class TwoSum_1_1 {
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
