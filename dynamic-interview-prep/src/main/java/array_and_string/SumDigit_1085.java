package array_and_string;

public class SumDigit_1085 {
  public int sumOfDigits(int[] nums) {
    int min = Integer.MAX_VALUE;
    for(int num : nums) {
      if(num < min) {
        min = num;
      }
    }

    int sum = 0;
    while(min > 0) {
      sum = sum + min % 10;
      min = min / 10;
    }

    if (sum % 2 == 0) {
      return 1;
    }
    return 0;
  }
}
