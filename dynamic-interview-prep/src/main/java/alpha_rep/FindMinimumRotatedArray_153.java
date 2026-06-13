package alpha_rep;

public class FindMinimumRotatedArray_153 {
  public int findMin(int[] nums) {
    int l = 0, h = nums.length - 1;

    while(l < h) {
      int m = l + (h - l) / 2;
      if(nums[m] > nums[h]) {
        //minimum must be on the right side
        l = m + 1;
      } else {
        h = m;
      }
    }
    return nums[l];
  }
}
