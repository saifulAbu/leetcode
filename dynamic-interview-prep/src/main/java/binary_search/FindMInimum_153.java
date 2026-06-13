package binary_search;

//noted
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

  public int findMin_drona(int[] nums) {
    int l = 0, h = nums.length - 1;

    while (l < h) {
      int m = l + (h - l) / 2;

      if (nums[m] > nums[h]) {
        l = m + 1;      // minimum is strictly to the right
      } else {
        h = m;          // minimum is at m or to the left
      }
    }

    return nums[l];
  }

}
