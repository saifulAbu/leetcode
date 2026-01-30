package array_and_string;

public class XorTotals_1863 {
  public int subsetXORSum(int[] nums) {
    // for n, loop through all 2 ^ n numbers
    // for each i, figure out the elements of the array
    // xor, add them up
    int totalSize = (int) Math.pow(2, nums.length);
    int xorSum = 0;
    for (int i = 0; i < totalSize; i++) {
      xorSum += getXor(i, nums);
    }
    return xorSum;
  }

  private int getXor(int set, int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      if( (set & 1) == 1) {
        xor = xor ^ nums[i];
      }
      set = set >> 1;
    }
    return xor;
  }

  public static void main(String args[]) {
    XorTotals_1863 x = new XorTotals_1863();
    int [] arr = {3,4,5,6,7,8};
    System.out.println(x.subsetXORSum(arr));
  }
}
