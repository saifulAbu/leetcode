package array_and_string;

import java.util.Arrays;

public class SquareSorted_977 {

  public int[] sortedSquares(int[] nums) {
    // square the numbers
    // -3 -2 -1 0 1 2 3
    for(int i = 0; i < nums.length; i++)
    {
      nums[i] *= nums[i];
    }
    // now i have an array that descending then ascending
    // 9 4 1 0 1 4 9
    // sort this new new array using l and r pointers
    // on the new array
    int[] res = new int[nums.length];
    int l = 0;
    int r = nums.length - 1;
    int i = r;

    while(l <= r){
      res[i--] = (nums[r] > nums[l] ? nums[r--]: nums[l++]);
    }

    return res;
  }

  public int[] sortedSquares1(int[] nums) {
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

  public int[] sortedSquares0(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      nums[i] *= nums[i];
    }
    Arrays.sort(nums);
    return nums;
  }
}
