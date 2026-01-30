package array_and_string;

public class RotateArray_189 {

  public void rotate(int[] nums, int k) {
    // input 6 size array, following are the indices
    // 0 1 2 3 4 5
    // k = 3
    // following is the index switches
    // 0 => 3, 3 => 0
    // 1 => 4, 4 => 1
    // 2 => 5, 5 => 2
    int ARRAY_LEN = nums.length;
    k = k % ARRAY_LEN;
    int totalSwap = 0;
    // this loop generates first indices to start with,
    // 0, 1, 2
    for(int i = 0; i < k; i++) {
      // for index 0, the following function rotates 0 => 2, 2 => 0.
      // returns 2 as 2 elements got touched with the rotations
      totalSwap += rotate(nums, k, i);
      if(totalSwap == ARRAY_LEN) {
        break;
      }
    }
  }

  // shifts elements k places starting startIndex
  // does not touch all the elements
  // for the example above, if presented 0 index
  // prevIndex => curIndex
  // 3 => 0, 0 => 3 loop breaks when reaches 3 => 0 again
  private int rotate(int[] nums, int k, int startIndex) {
    int ARRAY_LEN = nums.length;
    int prevIndex = (ARRAY_LEN + startIndex - k) % ARRAY_LEN;
    int prevVal = nums[prevIndex];
    int swaps = 0;

    while(true) {
      int curIndex = (prevIndex + k) % ARRAY_LEN;
      if(curIndex == startIndex && swaps > 0) {
        break;
      }
      int curVal = nums[curIndex];
      nums[curIndex] = prevVal;
      prevVal = curVal;
      prevIndex = curIndex;
      swaps++;
    }

    return swaps;
  }

  public void rotate0(int[] nums, int k) {
    int swaps = 0;
    for(int i = 0; i < nums.length && swaps < nums.length; i++) {
      int prev = nums[i];
      for (int j = (i + k) % nums.length; j != i && swaps < nums.length; j = (j + k) % nums.length) {
        int cur = nums[j];
        nums[j] = prev;
        prev = cur;
        swaps++;
      }
      nums[i] = prev;
      swaps++;
    }
  }
}
