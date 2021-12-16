package array_and_string;

import java.util.Arrays;

public class SquareSorted_977 {
  public int[] sortedSquares(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      nums[i] *= nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }
}
