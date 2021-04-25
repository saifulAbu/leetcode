package array_and_string;

public class SignOfTheProductOfArray_1822 {
  public int arraySign(int[] nums) {
    int numNegative = 0;
    boolean isZero = false;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        isZero = true;
        break;
      }
      if (nums[i] < 0) {
        numNegative++;
      }
    }

    if (isZero) {
      return 0;
    }
    if (numNegative % 2 == 0) {
      return 1;
    } else {
      return  -1;
    }
  }
}
