package array_and_string;

public class FindPivotIndex_724 {
  public int pivotIndex(int[] nums) {
    int rightSum = 0;
    for (int n : nums) {
      rightSum += n;
    }
    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }

  public int pivotIndex0(int[] nums) {
    int [] sum = new int[nums.length + 1];
    sum[0] = 0;

    for(int i = 0; i < nums.length; i++) {
      sum[i+1] = sum[i] + nums[i];
    }

    for(int i = 0; i < nums.length; i++) {
      int leftSum = sum[i];
      int rightSum = sum[nums.length] - sum[i+1];
      if(leftSum == rightSum) {
        return i;
      }
    }

    return -1;
  }
}
