package array_and_string;

public class NumsSmallerThanCur_1365 {
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int[] res = new int[nums.length];

    for(int i = 0; i < nums.length; i++) {
      for(int j = 0; j < nums.length; j++) {
        if(nums[j] < nums[i]) {
          res[i]++;
        }
      }
    }

    return res;
  }

}
