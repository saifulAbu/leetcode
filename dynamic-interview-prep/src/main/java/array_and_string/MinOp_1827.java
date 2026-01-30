package array_and_string;

public class MinOp_1827 {
  public int minOperations(int[] nums) {
    int minOp = 0;
    for(int i = 1; i < nums.length; i++) {
      if (nums[i-1] > nums[i]) {
        int curOp = nums[i-1] - nums[i] + 1;
        minOp += curOp;
        nums[i] += curOp;
      }
    }
    return minOp;
  }
}
