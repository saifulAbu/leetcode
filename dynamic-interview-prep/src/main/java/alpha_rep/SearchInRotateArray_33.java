package alpha_rep;

public class SearchInRotateArray_33 {
  public int search(int[] nums, int target) {
    /*
    * all elements are unique
    * 0 1 2 3 4 5 6 7 8
    * if we left rotate
    * 4 5 6 7 8 0 1 2 3
    * as we can see, one part is 4, 5, 6, 7, 8 another part is 0, 1, 2, 3
    * both parts are increasing. my mid point can be in a place, where left part is sorted or right part is sorted
    * we want to know which part is sorted because, from that side, we for sure know if my element lies on that part.
    * example, lets say i am looking for element 5, if i look into the right part, 8, 0, 1, 2, 3 i cannot for sure tell
    * if 2 lies there. so we check on the left side, is 4 <= target(2) <= 8? no so target must lie on the right side.
    *
    * the <= equality is needed because target could be the l or h elements
    *
    * */

    int l = 0, h = nums.length - 1;

    while(l <= h) {
      int m = l + (h - l) / 2; // this can overflow for larger h and l, m = (l + h) / 2;
      if(target == nums[m]) {
        return m;
      }

      if(nums[l] <= nums[m]) { // using <= because it could be one element array [2] it should be treated as sorted
        //left part is sorted
        //lets check if our target lies within
        if(nums[l] <= target && target < nums[m]) {
          h = m - 1;
        } else {
          // target element is on the unsorted part
          l = m + 1;
        }
      } else {
        //right part is sorted
        if(nums[m] < target && target <= nums[h]) {
          l = m + 1;
        } else {
          h = m - 1;
        }
      }
    }

    // could not find in side my array
    return -1;
  }


  public int search_0(int[] nums, int target) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
      int m = l + (h - l) / 2;

      if (nums[m] == target) {
        return m;
      } else if(nums[l] <= nums[m]){
        //left part does not have pivot element, all elements are sorted
        if (nums[l] <= target && target <= nums[m]) {
          h = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        if (nums[m] <= target && target <= nums[h]) {
          l = m + 1;
        } else {
          h = m - 1;
        }
      }
    }
    return -1;
  }
}
