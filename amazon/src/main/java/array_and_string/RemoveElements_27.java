package array_and_string;

public class RemoveElements_27 {
  public int removeElement(int[] nums, int val) {
    int f = 0;
    int e = nums.length - 1;

    while(f <= e) {
      if(nums[f] == val) {
        nums[f] = nums[e];
        nums[e] = val;
        e--;
      } else {
        f++;
      }
    }
    return f;
  }
}
