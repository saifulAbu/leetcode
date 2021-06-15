package array_and_string;

public class RepeatedElements_961 {
  public int repeatedNTimes(int[] nums) {
    int l = nums.length;
    int res = -1;
    for(int i = 0; i < l; i++) {
      if((i + 1 < l && nums[i] == nums[i+1]) ||
          (i + 2 < l && nums[i] == nums[i+2]) ||
          (i + 3 < l && nums[i] == nums[i+3])) {
          res = nums[i];
          break;
      }
    }
    return res;
  }
}
