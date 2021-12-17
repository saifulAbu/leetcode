package array_and_string;

import java.util.Arrays;

public class SquareSorted_977 {
  public int[] sortedSquares1(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      nums[i] *= nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }

  public int[] sortedSquares(int[] nums) {
    int l = 0, r = nums.length - 1;
    int [] res = new int[nums.length];
    for (int i = res.length - 1; i >= 0; i--) {
      if (Math.abs(nums[l]) > Math.abs(nums[r])) {
        res[i] = nums[l] * nums[l];
        l++;
      } else {
        res[i] = nums[r] * nums[r];
        r--;
      }
    }
    return res;
  }
}
