package array_and_string;

public class SumOfDigits_1837 {
  public int sumBase(int n, int k) {
    int sum = 0;
    while(n > 0) {
      sum = sum + n % k;
      n = n / k;
    }
    return sum;
  }
}
