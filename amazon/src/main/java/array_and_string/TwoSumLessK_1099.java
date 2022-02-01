package array_and_string;

import java.util.Arrays;

public class TwoSumLessK_1099 {
  public int twoSumLessThanK(int[] nums, int k) {
    Arrays.sort(nums);
    int l = 0, h = nums.length - 1, res = -1;
    while (l < h) {
      if (nums[l] + nums[h] >= k) {
        h--;
      } else {
        res = Math.max(res, nums[l] + nums[h]);
        l++;
      }
    }
    return res;
  }
}
