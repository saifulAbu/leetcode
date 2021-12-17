package array_and_string;

public class LargestNumberAtLeastTwice_747 {
  public int dominantIndex(int[] nums) {
    int mi = -1;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        mi = i;
        max = nums[i];
      }
    }

    for (int n : nums) {
      if (2 * n > max) {
        return -1;
      }
    }

    return max;

  }
}
