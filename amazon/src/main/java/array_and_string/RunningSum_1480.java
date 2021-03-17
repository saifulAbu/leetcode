package array_and_string;

public class RunningSum_1480 {
  public int[] runningSum(int[] nums) {
    for(int i = 1; i < nums.length; i++) {
      nums[i] += nums[i-1];
    }
    return nums;
  }
}
