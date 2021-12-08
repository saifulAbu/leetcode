package array_and_string;

public class RotateArray_189 {
  public void rotate(int[] nums, int k) {
    int swaps = 0;
    for(int i = 0; i < nums.length && swaps < nums.length; i++) {
      int prev = nums[i];
      for (int j = (i + k) % nums.length; j != i && swaps < nums.length; j = (j + k) % nums.length) {
        int cur = nums[j];
        nums[j] = prev;
        prev = cur;
        swaps++;
      }
      nums[i] = prev;
      swaps++;
    }
  }
}
