package array_and_string;

public class IntegerToEnglish_273 {
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    final int BILLION = 1_000_000_000, MILLION = 1_000_000, THOUSAND = 1_000;
    int billions = 0, millions = 0, thousands = 0;
    billions = num / BILLION;
    millions = (num - billions * BILLION ) / MILLION;
    thousands = (num - billions * BILLION - millions * MILLION) / THOUSAND;
    int remaining = num - billions * BILLION - millions * MILLION - thousands * THOUSAND;

    String res = "";
    if (billions != 0) {
      res = res +  numberToWordsHellper(billions) + " Billion";
    }
    if (millions != 0) {
      res = res + " " + numberToWordsHellper(millions) + " Million";
    }
    if (thousands != 0) {
      res = res + " " + numberToWordsHellper(thousands) + " Thousand";
    }
    if (remaining != 0) {
      res = res + " " +  numberToWordsHellper(remaining);
    }
    return res.trim();
  }

  private String numberToWordsHellper(int num) {
    int d2 = 0, d1 = 0, d0 = 0;
    d0 = num % 10;
    num /= 10;
    d1 = num % 10;
    num /= 10;
    d2 = num % 10;
    return toEnglish(d2, d1, d0);
  }

  private String toEnglish(int n) {
    String res = "";
    switch (n) {
      case 1:
        res = "One";
        break;
      case 2:
        res = "Two";
        break;
      case 3:
        res = "Three";
        break;
      case 4:
        res = "Four";
        break;
      case 5:
        res = "Five";
        break;
      case 6:
        res = "Six";
        break;
      case 7:
        res = "Seven";
        break;
      case 8:
        res = "Eight";
        break;
      case 9:
        res = "Nine";
    }
    return res;
  }

  private String toEnglish(int d1, int d0) {
    String res = "";
    if (d1 == 0) {
      res = toEnglish(d0);
    } else if(d1 == 1) {
      int num = d1 * 10 + d0;
      switch (num) {
        case 10:
          res = "Ten";
          break;
        case 11:
          res = "Eleven";
          break;
        case 12:
          res = "Twelve";
          break;
        case 13:
          res = "Thirteen";
          break;
        case 14:
          res = "Fourteen";
          break;
        case 15:
          res = "Fifteen";
          break;
        case 16:
          res = "Sixteen";
          break;
        case 17:
          res = "Seventeen";
          break;
        case 18:
          res = "Eighteen";
          break;
        case 19:
          res = "Nineteen";
          break;
      }
    } else {
      switch (d1) {
        case 2:
          res = "Twenty";
          break;
        case 3:
          res = "Thirty";
          break;
        case 4:
          res = "Forty";
          break;
        case 5:
          res = "Fifty";
          break;
        case 6:
          res = "Sixty";
          break;
        case 7:
          res = "Seventy";
          break;
        case 8:
          res = "Eighty";
          break;
        case 9:
          res = "Ninety";
      }
      if (d0 != 0) {
        res = res + " " + toEnglish(d0);
      }
    }
    return res;
  }

  private String toEnglish(int d2, int d1, int d0) {
    String res = "";
    if (d2 != 0) {
      res = toEnglish(d2) + " Hundred";
    }
    if(d1 != 0 || d0 != 0) {
      if(!res.isEmpty()) {
        res = res + " ";
      }
      res = res + toEnglish(d1, d0);
    }
    return res;
  }

  public static void main(String args[]) {
    IntegerToEnglish_273 it = new IntegerToEnglish_273();
    System.out.println(Integer.MAX_VALUE);
    System.out.println(it.numberToWords(Integer.MAX_VALUE));
  }
}
