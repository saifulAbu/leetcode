package array_and_string;

public class ConvertToHex_405 {
  public String toHex(int num) {
    if(num < 0) {
      num = twosComp(num);
    }
    String res = "";
    while(num > 0) {
      res = getDigit(num % 16) + res;
      num = num / 16;
    }
    return res;
  }

  private int twosComp(int num) {
    return Integer.MAX_VALUE - Math.abs(num) + 1;
  }

  private char getDigit(int num) {
    if(num < 10) {
      return (char) (num + '0');
    } else if (num == 10) {
      return 'a';
    } else if (num == 11) {
      return 'b';
    } else if (num == 12) {
      return 'c';
    } else if (num == 13) {
      return 'd';
    } else if (num == 14) {
      return 'd';
    } else if (num == 15) {
      return 'e';
    } else {
      return 'f';
    }
  }
}


//more