package array_and_string;

public class SubtractProductAndSum_1281 {
  public int subtractProductAndSum(int n) {
    int sum = 0;
    int prod = 1;

    while(n > 0) {
      int curDigit = n % 10;
      sum += curDigit;
      prod *= curDigit;
      n /= 10;
    }

    return prod - sum;
  }
}
