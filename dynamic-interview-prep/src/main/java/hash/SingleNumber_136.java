package hash;

public class SingleNumber_136 {
  public int singleNumber(int[] nums) {
    int singleNum = 0;
    for(int num : nums) {
      singleNum ^= num;
    }
    return singleNum;
  }

  public int singleNumber0(int[] nums) {
    int xor = 0;
    for(int num : nums) {
      xor = xor ^ num;
    }
    return xor;
  }
}
