package array_and_string;

public class PlusOne_66 {

  public int[] plusOne(int[] digits) {
    //check if all digits are 9s
    boolean all9s = true;
    for(int i = 0; i < digits.length; i++) {
      if(digits[i] != 9) {
        all9s = false;
        break;
      }
    }

    // if all digits are 9s
    // 9, 99, or 999 => 10, 100, 1000
    // create a new array and set first digit to 1
    if(all9s) {
      int [] res = new int[digits.length + 1];
      res[0] = 1;
      return res;
    }

    //not all digits are 9
    // 998 => 999
    // 899 => 900
    int carry = 1;
    for(int i = digits.length - 1; i >= 0; i--) {
      int curSum = digits[i] + carry;
      digits[i] = curSum % 10;
      carry = curSum / 10;
    }

    return digits;
  }

  public int[] plusOne1(int[] digits) {
    int i = digits.length - 1;
    while (i >=0 && digits[i] == 9) {
      digits[i] = 0;
      i--;
    }
    //all digits are 9
    if (i < 0) {
      int [] res = new int[digits.length + 1];
      res[0] = 1;
      return res;
    } else {
      digits[i] += 1;
      return digits;
    }
  }

  public int[] plusOne0(int[] digits) {
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

