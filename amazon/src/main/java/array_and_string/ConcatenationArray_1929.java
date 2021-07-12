package array_and_string;

public class ConcatenationArray_1929 {
  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int [] res = new int[n * 2];
    for(int i = 0; i < n; i++) {
      res[i] = res[i + n] = nums[i];
    }
    return res;
  }
}
