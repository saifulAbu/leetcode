package binary_search;

public class FindMInimum_153 {
  public int findMin(int[] nums) {
    int n = nums.length, l = 0, r = n - 1;
    while (l < r) {
      int m = l + (r - l) / 2;
      int cur = nums[m];
      if (m - 1 >= 0) {
        int prev = nums[m - 1];
        if (prev > cur) {
          return cur;
        }
      }
      if (nums[l] > nums[r]) {
        if (nums[l] <= nums[m]) {
          l = m + 1;
        } else {
          r = m;
        }
      } else {
        r = m;
      }
    }
    return nums[r];
  }
}
