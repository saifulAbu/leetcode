package array_and_string;

public class RemoveDuplicatedSorted_26 {
  public int removeDuplicates(int[] nums) {
    if(nums.length <= 1) {
      return nums.length;
    }
    int size = 1;
    for (int nextUniqueElemIdx = 1; nextUniqueElemIdx < nums.length; nextUniqueElemIdx++) {
      if (nums[size - 1] != nums[nextUniqueElemIdx]) {
        nums[size++] = nums[nextUniqueElemIdx];
      }
    }
    return size;
  }
}
