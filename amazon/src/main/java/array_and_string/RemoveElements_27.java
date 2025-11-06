package array_and_string;

public class RemoveElements_27 {
  public int removeElement(int[] nums, int val) {
    // 1 5 5 6 5 val = 5
    // initiate 2 pointers, l and r
    // every elem at i < l is != val
    // every elem i > r is == val
    int l = 0;
    int r = nums.length - 1;
    while(l <= r){
      //find the first val on left side
      while((l < nums.length) && nums[l] != val) {
        l++;
      }
      // find the first elem on right side != val
      while(r >= 0 && nums[r] == val) {
        r--;
      }

      if(l < r) {
        nums[l++] = nums[r];
        nums[r--] = val;
      }
    }

    // l also represents all the elements != val
    return l;
  }

  public int removeElement1(int[] nums, int val) {
    int f = 0;
    int e = nums.length - 1;

    while(f <= e) {
      if(nums[f] == val) {
        nums[f] = nums[e];
        nums[e] = val;
        e--;
      } else {
        f++;
      }
    }
    return f;
  }
  public int removeElement0(int[] nums, int val) {
    int insertIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        int t = nums[insertIndex];
        nums[insertIndex++] = nums[i];
        nums[i] = t;
      }
    }
    return insertIndex;
  }
}

//restarting