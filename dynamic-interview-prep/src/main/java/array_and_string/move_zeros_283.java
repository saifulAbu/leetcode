package array_and_string;

public class move_zeros_283 {
  public void moveZeroes(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != 0) {
        continue;
      }
      int j = i + 1;
      for(; j < nums.length; j++) {
        if(nums[j] != 0) {
          break;
        }
      }
      if(j == nums.length) {
        break;
      }
      nums[i] = nums[j];
      nums[j] = 0;
    }
  }

  public void moveZeroes_0(int[] nums) {
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
