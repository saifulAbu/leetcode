package array_and_string;

public class Maximum69Num_1323 {
  public int maximum69Number (int num) {
    int numDigits = (int) (Math.log10(num) + 1);
    int digit[] = new int[numDigits];

    for (int i = numDigits - 1; i >= 0; i--) {
      digit[i] = num % 10;
      num = num / 10;
    }

    for (int i = 0; i < numDigits; i++) {
      if(digit[i] == 6) {
        digit[i] = 9;
        break;
      }
    }

    int res = 0;
    for (int i = 0; i < numDigits; i++) {
      res = res * 10 + digit[i];
    }
    return res;
  }

  public static void main(String args[]) {
    Maximum69Num_1323 m = new Maximum69Num_1323();
    System.out.println(m.maximum69Number(696969));
  }
}
