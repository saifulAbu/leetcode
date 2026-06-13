package alpha_rep;

public class BinarySearch_704 {

  public int search(int[] nums, int target) {
    int l = 0, h = nums.length - 1;
    while(l <= h) {
      int m = l + (h - l) / 2;
      int midElem = nums[m];
      if(midElem < target) {
        l = m + 1;
      } else if(target < midElem) {
        h = m - 1;
      } else {
        return m;
      }
    }
    return -1;
  }

  public int search_1(int[] nums, int target) {
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
     *
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
    return -1;
  }

  public int search_0(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (nums[m] == target) {
        return m;
      } else if (nums[m] < target) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    return -1;
  }

  public int search_drona(int[] nums, int target) {
    int l = 0;
    int h = nums.length - 1;

    while(l <= h) {
      int m = l + (h-l) / 2;
      if(nums[m] == target) {
        return m;
      } else if(nums[m] > target) {
        h = m - 1;
      } else {
        l = m + 1;
      }
    }
    return -1;
  }
}
