package binary_search;

public class FindPeakElement_162 {
  public int findPeakElement_drona(int[] nums) {
    /*
    * please go through the problem description
    * it states a valid input will not have consequtive numbers that are equal
    * [1 2 3 4 5] is valid while [1 2 2 2 3] is not
    * givent that constraint, for a valid input array, we will always have a peak element
    * also peak element is not the highest element
    * [1 0 9 8 6] for this input, 1 is a valid answer, because it is bigger than its neighbors
    * given this constraints, we can find the m
    * nums[m] > nums[m+1] then we probably have an peak element from [l ... m]
    * else we have a peak element in [m+1 ... h]
    *
    * */
    int l = 0, h = nums.length - 1;

    while(l < h) {
      int m = l + (h - l) / 2;
      if(nums[m] < nums[m+1]) {
        l = m + 1;
      } else {
        h = m; // m element could be the peak
      }
    }

    return l;
  }

  public int findPeakElement_0(int[] nums) {
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
