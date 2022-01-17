package binary_search;

public class FindPeakElement_162 {
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    int res = -1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      int next = Integer.MIN_VALUE;
      int cur = nums[m];
      int prev = Integer.MIN_VALUE;
      if (m - 1 >= 0) {
        prev = nums[m - 1];
      }
      if (m + 1 < nums.length) {
        next = nums[m + 1];
      }
      if (prev <= cur && cur >= next) {
        res = m;
        break;
      } else if (prev <= cur && cur <= next ) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return res;
  }
}
