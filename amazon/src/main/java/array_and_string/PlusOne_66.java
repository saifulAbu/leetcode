package array_and_string;

public class PlusOne_66 {
  public int[] plusOne(int[] digits) {
    //check if all digits are 9
    boolean allNine = true;
    for (int d : digits) {
      if (d != 9) {
        allNine = false;
        break;
      }
    }
    int [] res = digits;
    if (allNine) {
      res = new int [digits.length + 1];
    }

    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int curSum = carry + digits[i];
      int curD = curSum % 10;
      carry = curSum / 10;
      res[i] = curD;
    }

    if (allNine) {
      res[0] = carry;
    }
    return res;
  }
}

