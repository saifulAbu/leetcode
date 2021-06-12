package array_and_string;

public class MaximumProduct_1464 {
  public int maxProduct(int[] nums) {
    int maxI = 0;
    maxI = findMaxIndex(nums);
    int val0 = nums[maxI];

    nums[maxI] = Integer.MIN_VALUE;
    maxI = findMaxIndex(nums);
    int val1 = nums[maxI];

    return (val0 - 1) * (val1 - 1);
  }

  private int findMaxIndex(int [] arr) {
    int maxI = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxI = i;
      }
    }
    return maxI;
  }
}
