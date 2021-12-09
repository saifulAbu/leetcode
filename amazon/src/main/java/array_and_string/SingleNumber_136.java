package array_and_string;

public class SingleNumber_136 {
  public int singleNumber(int[] nums) {
    int xor = 0;
    for(int num : nums) {
      xor = xor ^ num;
    }
    return xor;
  }
}
