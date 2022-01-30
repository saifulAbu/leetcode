package binary_search;

public class FindMinRotatedSorted_154 {
  public int findMin(int[] nums) {
    int l = 0, h = nums.length - 1;
    while (l < h) {
      int m = l + (h - l) / 2;
      int L, M, H;
      L = nums[l];
      M = nums[m];
      H = nums[h];
      if (L < M) {
        if (L < H) {
          h = m - 1;
        } else if (l > h) {
          l = m + 1;
        } else {
          l = m + 1;
        }
      } else if (L > M) {
        if (L < H) {
          h = m;
        } else if (l > h) {
          h = m;
        } else {
          h = m;
        }
      } else {
        if (L < H) {
          h = m;
        } else if (l > h) {
         l = m + 1;
        } else {
         l = l + 1;
        }
      }
    }
    return nums[l];
  }
}