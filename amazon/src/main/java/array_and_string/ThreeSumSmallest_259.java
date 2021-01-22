package array_and_string;

import java.util.Arrays;

public class ThreeSumSmallest_259 {

  public int threeSumSmaller(int[] nums, int target) {
    int smallerSumCount = 0;

    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++) {
      int low = i + 1;
      int high = nums.length -1;
      while(low < high) {
        if(nums[i] + nums[low] + nums[high] < target){
          //if we fix i and low for the first to members of the tuple, how many possiblities i have for the third member of the tuple?
          smallerSumCount += high - low;
          low++;
        } else {
          high--;
        }
      }
    }
    return smallerSumCount;
  }

  public int threeSumSmaller2(int[] nums, int target) {
    int smallerSumCount = 0;

    Arrays.sort(nums);

    for(int i = 0; i < nums.length - 2; i++) {
      for(int j = i+1; j < nums.length - 1; j++) {
        int low = j + 1;
        int high = nums.length - 1;
        //the index high will give the max index where nums[i] + nums[j] + nums[high] < target
        while(low < high) {
          int mid = (low + high) / 2;
          if(nums[i] + nums[j] + nums[mid] >= target) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }

        smallerSumCount += (high - j);
      }
    }
    return smallerSumCount;
  }

  public static void main(String args[]) {
    ThreeSumSmallest_259 sol = new ThreeSumSmallest_259();
    int[] nums = {-1, -1, -1, -1};
    int target = -1;

    System.out.println(sol.threeSumSmaller(nums, target));
  }
}
