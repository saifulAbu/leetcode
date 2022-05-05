package array_and_string;

public class ConvertToHex_405 {
  public String toHex(int num) {
    if(num == 0) {
      return "0";
    }
    long longNum = num;
    if(num < 0) {
      longNum = twosComp(num);
    }
    System.out.println(longNum);
    String res = "";
    while(longNum > 0) {
      res = getDigit(longNum % 16) + res;
      longNum /= 16;
    }
    return res;
  }

  private long twosComp(int num) {
    return (0xffffffffL + 1) - Math.abs((long)num) ;
  }

  private char getDigit(long num) {
    if(num < 10) {
      return (char) (num + '0');
    } else if (num == 10L) {
      return 'a';
    } else if (num == 11L) {
      return 'b';
    } else if (num == 12L) {
      return 'c';
    } else if (num == 13L) {
      return 'd';
    } else if (num == 14L) {
      return 'e';
    } else {
      return 'f';
    }
  }
}


//more