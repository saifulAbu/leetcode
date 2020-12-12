package com.company;

import java.util.Arrays;

public class SingleNumberII {
  public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    while(i < nums.length - 2) {
      if(nums[i] == nums[i+1]) {
        i += 3;
      } else {
        break;
      }
    }
    return nums[i];
  }

  public static void main(String argsp[]) {
    SingleNumberII sing = new SingleNumberII();
    int [] nums = {1, 1, 1, 2, 3, 3, 3, 5, 5, 5};
    System.out.println(sing.singleNumber(nums));
  }
}
