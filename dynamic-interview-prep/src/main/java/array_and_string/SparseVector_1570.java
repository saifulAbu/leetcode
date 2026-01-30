package array_and_string;

public class SparseVector_1570 {
  private int [] nums;
  SparseVector_1570(int[] nums) {
    this.nums = nums;
  }

  // Return the dotProduct of two sparse vectors
  public int dotProduct(SparseVector_1570 vec) {
    int res = 0;
    for(int i = 0; i < nums.length; i++) {
      res = res + this.nums[i] * vec.nums[i];
    }
    return res;
  }
}