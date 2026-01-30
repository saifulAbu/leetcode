package array_and_string;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum_15 {
  public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> res = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for(int i = 0; i < nums.length - 2; i++) {
      for(int j = i+1; j < nums.length - 1; j++) {
        int remainingValue = 0 - nums[i] - nums[j];
        if(map.containsKey(remainingValue) && map.get(remainingValue) > j) {
          List<Integer> curSolution = Arrays.asList(nums[i], nums[j], nums[map.get(remainingValue)]);
          Collections.sort(curSolution);
          res.add(curSolution);
        }
      }
    }
    return new ArrayList<>(res);
  }

  public static void main(String args[]) {
    ThreeSum_15 sol = new ThreeSum_15();
    int[] arr = {-1,0,1,2,-1,-4};
    //int []arr2 = {0};
    System.out.println(sol.threeSum(arr));
  }
}
