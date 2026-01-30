package hash;

//https://leetcode.com/problems/two-sum/
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numIndexMap = new HashMap<>();
    int[] res = new int[2];
    for(int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num0 = target - num1;
      if(numIndexMap.containsKey(num0)) {
        int index0 = numIndexMap.get(num0);
        res[0] = index0;
        res[1] = i;
        break;
      }
      numIndexMap.put(num1, i);
    }
    return res;
  }

  public int[] twoSum0(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> map = new HashMap();

    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for(int i = 0; i < nums.length; i++) {
      int num0 = nums[i];
      int num1 = target - num0;
      if(map.containsKey(num1) && map.get(num1) != i) {
        res[0] = i;
        res[1] = map.get(num1);
        return res;
      }
    }

    return res;
  }
}
