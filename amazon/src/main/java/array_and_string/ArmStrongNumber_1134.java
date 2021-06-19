package array_and_string;

public class ArmStrongNumber_1134 {
  public boolean isArmstrong(int n) {
    int num = n;
    int sum = 0;
    int numDigit = (int) (Math.log10(n) + 1);

    while (num > 0) {
      int curdigit = num % 10;
      sum += Math.pow(curdigit, numDigit);
      num /= 10;
    }

    if (sum == n) {
      return true;
    }
    return false;
  }
}

//Dummy
