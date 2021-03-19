package array_and_string;

public class ShuffleArray_1470 {
  public int[] shuffle(int[] nums, int n) {
    int [] res = new int[2 * n];

    for(int i = 0; i < n; i++) {
      int j = i * 2;
      res[j] = nums[i];
    }

    for(int i = n; i < 2 * n; i++) {
      int j = (i - n) * 2 + 1;
      res[j] = nums[i];
    }

    return res;
  }
}
