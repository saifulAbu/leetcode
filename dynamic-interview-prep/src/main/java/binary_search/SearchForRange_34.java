package binary_search;

public class SearchForRange_34 {

  public int[] searchRange(int[] nums, int target) {
    /*
    * in this problem, we are trying to find left and right index
    * leftIndex is either 0, or an index where nums[i-1] < target && nums[i] == target
    * that's what we search.
    *
    * we do the same for the right side
    * */
    int leftIndex = -1, rightIndex = -1, len = nums.length;
    if(len == 0) {
      return new int[] {-1, -1};
    }

    if(nums[0] == target) {
      leftIndex = 0;
    }
    if(nums[len - 1] == target) {
      rightIndex = len - 1;
    }

    // find left index
    int l = 0, h = nums.length - 1;
    while(l <= h && leftIndex < 0) {
      int m = l + (h - l) / 2;
      if(m > 0 && nums[m] == target && nums[m - 1] < target) {
        leftIndex = m;
        break;
      }
      if(nums[m] == target) {
        h = m - 1;
      } else if(nums[m] < target){
        l = m + 1;
      } else if (nums[m] > target) {
        h = m - 1;
      }
    }

    //find right Index
    l = 0;
    h = nums.length - 1;
    while(l <= h && rightIndex < 0) {
      int m = l + (h - l) / 2;
      if(m < len - 1 && nums[m] == target && nums[m + 1] > target) {
        rightIndex = m;
        break;
      }
      if(nums[m] == target) {
        l = m + 1;
      } else if(nums[m] < target){
        l = m + 1;
      } else if (nums[m] > target) {
        h = m - 1;
      }
    }

    return new int[] {leftIndex, rightIndex};
  }

  public int[] searchRange_drona(int[] nums, int target) {
    return new int[]{findLeft(nums, target), findRight(nums, target)};
  }

  private int findLeft(int[] nums, int target) {
    int l = 0, h = nums.length - 1, result = -1;
    while (l <= h) {
      int m = l + (h - l) / 2;
      if (nums[m] == target) {
        result = m;    // record and keep going left
        h = m - 1;
      } else if (nums[m] < target) {
        l = m + 1;
      } else {
        h = m - 1;
      }
    }
    return result;
  }

  private int findRight(int[] nums, int target) {
    int l = 0, h = nums.length - 1, result = -1;
    while (l <= h) {
      int m = l + (h - l) / 2;
      if (nums[m] == target) {
        result = m;    // record and keep going right
        l = m + 1;
      } else if (nums[m] < target) {
        l = m + 1;
      } else {
        h = m - 1;
      }
    }
    return result;
  }

  public int[] searchRange_0(int[] nums, int target) {
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
