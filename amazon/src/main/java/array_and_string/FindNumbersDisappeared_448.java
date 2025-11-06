package array_and_string;

import java.util.LinkedList;
import java.util.List;

public class FindNumbersDisappeared_448 {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    // 4 3 1 2
    // we want to transform the array to
    // 1 2 3 4
    for(int i = 0; i < nums.length; i++) {
      while(nums[i] != i+1) {
        // we keep swapping the element t at place i till we can
        // each t we touch is gurranted to go in proper place
        // after each swap, we make the array one step close to arr[t] == t+1
        int t = nums[i];
        if(nums[t-1] == t) {
          break;
        }
        nums[i] = nums[t-1];
        nums[t-1] = t;
      }
    }

    List<Integer> res = new LinkedList<>();
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != i + 1) {
        res.add(i+1);
      }
    }

    return res;
  }

  public List<Integer> findDisappearedNumbers0(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int targetIndex = Math.abs(nums[i]) - 1;
      if (nums[targetIndex] > 0) {
        nums[targetIndex] *= -1;
      }
    }

    List<Integer> res = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        res.add(i+1);
      }
    }
    return res;
  }
}
