package binary_search;

public class SearchForRange_34 {
  public int[] searchRange(int[] nums, int target) {
    return new int[] {findLeftIndex(nums, target), findRightIndex(nums, target)};
  }

  private int findLeftIndex(int[] nums, int target) {
    int n = nums.length, l = 0, r = n - 1, idx = -1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      int prev = Integer.MIN_VALUE;
      int cur = nums[m];
      if (m > 0) {
        prev = nums[m-1];
      }
      if (cur == target && cur > prev) {
        idx = m;
        break;
      }
      if (cur >= target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return idx;
  }

  private int findRightIndex(int[] nums, int target) {
    int n = nums.length, l = 0, r = n - 1, idx = -1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      int next = Integer.MAX_VALUE;
      int cur = nums[m];
      if (m < n - 1) {
        next = nums[m + 1];
      }
      if (cur == target && cur < next) {
        idx = m;
        break;
      }
      if (cur > target) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return idx;
  }
}
