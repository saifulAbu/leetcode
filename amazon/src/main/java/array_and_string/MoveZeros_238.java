package array_and_string;

public class MoveZeros_238 {
  public void moveZeroes(int[] nums) {
    for (int i = 0, nextNonZeroToInsert = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[nextNonZeroToInsert];
        nums[nextNonZeroToInsert++] = nums[i];
        nums[i] = temp;
      }
    }
  }
}
