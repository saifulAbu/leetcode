package binary_search;

public class FindMInimum_153 {
  public int findMin(int[] nums) {
    int n = nums.length, l = 0, r = n - 1, res = Integer.MIN_VALUE;
    while (l <= r) {
      int m = l + (r - l) / 2;
      int prev = Integer.MIN_VALUE;
      int cur = nums[m];
      if (m - 1 >= 0) {
        prev = nums[m - 1];
      }
      if (prev > cur) {
        res = m;
        break;
      }
      if (nums[l] > nums[r]) {
        if (nums[l] < nums[m]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else {
        r = m - 1;
      }
    }
    return res;
  }
}
