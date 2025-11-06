package array_and_string;

public class move_zeros_283 {
  public void moveZeroes(int[] nums) {
    // find the index that has a zero in it
    int zeroIndex = 0;
    for( ;zeroIndex < nums.length; zeroIndex++) {
      if(nums[zeroIndex] == 0) {
        break;
      }
    }

    // look for non-zero elems and swap with zero
    for(int i = zeroIndex + 1; i < nums.length; i++) {
      if(nums[i] != 0) {
        nums[zeroIndex++] = nums[i];
        nums[i] = 0;
      }
    }
  }
}
