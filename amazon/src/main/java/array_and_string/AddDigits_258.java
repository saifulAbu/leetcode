package array_and_string;

public class AddDigits_258 {
  public int addDigits(int num) {
    while (num >= 10) {
      num = sumDigits(num);
    }
    return num;
  }

  private int sumDigits(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}

