package array_and_string;

import java.util.Arrays;
//O(n ^ 2) solution

public class ThreeSumClosest_16 {
  public int threeSumClosest(int[] nums, int target) {
    int res = 0;
    Arrays.sort(nums);
    int closestSum = Integer.MAX_VALUE;
    int smallestDiff = Integer.MAX_VALUE;

    for(int i = 0; i < nums.length - 2; i++) {
      int low = i + 1;
      int high = nums.length - 1;
      while(low < high) {
        int curSum = nums[i] + nums[low] + nums[high];
        int curDiff = Math.abs(target - curSum);
        if(curDiff < smallestDiff) {
          smallestDiff = curDiff;
          closestSum = curSum;
        }
        if(curSum < target) {
          low++;
        } else {
          high--;
        }
      }
    }
    return closestSum;
  }

  public static void main(String args[]) {
    ThreeSumClosest_16 sol = new ThreeSumClosest_16();

    int[] nums = {-1,2,1,-4};
    int target = 1;
    System.out.println(sol.threeSumClosest(nums, target));
  }
}
