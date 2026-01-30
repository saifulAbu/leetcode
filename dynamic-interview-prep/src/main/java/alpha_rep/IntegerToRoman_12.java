package alpha_rep;

public class IntegerToRoman_12 {

  String[][] SYMBOL_TABLE = {
          {"I", "V", "X"},
          {"X", "L", "C"},
          {"C", "D", "M"},
          {"M", "", ""},
  };

  public String intToRoman(int num) {
    /*
     * case 1234
     * we will move from left to right and extract one digit at a time.
     * for each digit, there is a similar logic in roman number formation. we can maintain the following table
     * quick refresher, L = 50, C = 100, D = 500, M = 1000
     *   0 1 2
     * 0 I V X
     * 1 X L C
     * 2 C D M
     * 3 M _ _
     *
     * for the case 1234, we will first pick the digit 4. 4 is in one's place so we will use the table entry 0 for the
     * conversion. IV. next comes 3. we will use the symbols in row 1 of our table to compute 3. it will be XXX. so on
     * and so forth
     * */
    int curPosition = 0;
    String romanNum = "";
    while(num > 0) {
      int curDigit = num % 10;
      romanNum = convertDigit(curDigit, curPosition) + romanNum;
      num /= 10;
      curPosition++;
    }
    return romanNum;
  }

  private String convertDigit(int digit, int position) {
    String[] symbols = SYMBOL_TABLE[position];
    String ONE = symbols[0], FIVE = symbols[1], TEN = symbols[2];

    switch(digit) {
      case 1:
        return ONE;
      case 2:
        return ONE + ONE;
      case 3:
        return ONE + ONE + ONE;
      case 4:
        return ONE + FIVE;
      case 5:
        return FIVE;
      case 6:
        return FIVE + ONE;
      case 7:
        return FIVE + ONE + ONE;
      case 8 :
        return FIVE + ONE + ONE + ONE;
      case 9:
        return ONE + TEN;
    }
    return "";
  }

  public String intToRoman_0(int num) {
    String res = "";
    while(num > 0) {
      if(num >= 1000) {
        num -= 1000;
        res += "M";
      } else if(num >= 900) {
        num -= 900;
        res += "CM";
      } else if(num >= 500) {
        num -= 500;
        res += "D";
      } else if(num >= 400) {
        num -= 400;
        res += "CD";
      } else if(num >= 100) {
        num -= 100;
        res += "C";
      } else if(num >= 90) {
        num -= 90;
        res += "XC";
      } else if(num >= 50) {
        num -= 50;
        res += "L";
      } else if(num >= 40) {
        num -= 40;
        res += "XL";
      } else if(num >= 10) {
        num -= 10;
        res += "X";
      } else if(num >= 9) {
        num -= 9;
        res += "IX";
      } else if(num >= 5) {
        num -= 5;
        res += "V";
      } else if(num >= 4) {
        num -= 4;
        res += "IV";
      } else {
        num -= 1;
        res += "I";
      }
    }
    return res;
  }

  public static void main(String [] args) {
    IntegerToRoman_12 itr = new IntegerToRoman_12();
    System.out.println(itr.intToRoman(1994));
  }
}
