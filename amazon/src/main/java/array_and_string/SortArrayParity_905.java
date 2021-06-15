package array_and_string;

public class SortArrayParity_905 {
  public int[] sortArrayByParity(int[] nums) {
    int front = 0;
    int len = nums.length - 1;
    int back = len;
    while (front < len && back >= 0 && front < back) {
      while (front < len && front < back && nums[front] % 2 == 0) {
        front++;
      }

      while (back >= 0 && front < back &&  nums[back] % 2 != 0) {
        back--;
      }

      if (front < len && back >= 0 && nums[front] % 2 != 0 && nums[back] % 2 == 0) {
        int t = nums[front];
        nums[front] = nums[back];
        nums[back] = t;
      }
    }
    return nums;
  }
}
