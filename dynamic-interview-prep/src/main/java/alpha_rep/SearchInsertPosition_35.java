package alpha_rep;

public class SearchInsertPosition_35 {
  public int searchInsert(int[] nums, int target) {
    /*
     * we will apply binary search
     * l = 0, h = len - 1
     * while(l <= h) {
     *  mid = (l + h) / 2
     *  if(nums[mid] == target) {
     *    return mid;
     *  } else if (arr[mid] > target) {
     *    h = mid - 1;
     *  } else {
     *    l = mid + 1;
     *  }
     * }
     * return l; // this is the point when l == h happens.
     * */

    int l = 0, h = nums.length - 1;
    while(l <= h) {
      int m = (l + h) / 2;
      int midElem = nums[m];
      if(midElem == target) {
        return m;
      } else if (midElem > target) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return l;
  }
}
