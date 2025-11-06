package array_and_string;

public class FindNumbersEvenDigit_1295 {

  public int findNumbers(int[] nums) {
    int evenDigitNumCount = 0;
    for(int num : nums) {
      if (getDigitCount(num) % 2 == 0) {
        evenDigitNumCount++;
      }
    }
    return evenDigitNumCount;
  }

  private int getDigitCount(int num) {
    int digitCount = 1;
    while(num > 9) {
      num /= 10;
      digitCount++;
    }
    return digitCount;
  }

  public int findNumbers0(int[] nums) {
    int res = 0;

    for(int num : nums) {
      if((Math.floor(Math.log10(num)) + 1) % 2 ==  0) {
        res++;
      }
    }

    return res;
  }
}
