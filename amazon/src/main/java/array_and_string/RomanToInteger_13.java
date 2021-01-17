package array_and_string;

public class RomanToInteger_13 {
  public int romanToInt(String s) {
    int res = 0;
    char[] roman = s.toCharArray();
    int i = 0;

    while(i < roman.length) {
      char curNumeral = roman[i++];
      int curIntVal = 0;
      if(curNumeral == 'I') {
        curIntVal = 1;
        if(i < roman.length && (roman[i] == 'V' || roman[i] == 'X')){
          if(roman[i] == 'V') {
            curIntVal = 4;
          } else {
            curIntVal = 9;
          }
          i++;
        }
      } else if(curNumeral == 'X') {
        curIntVal = 10;
        if(i < roman.length && (roman[i] == 'L' || roman[i] == 'C')){
          if(roman[i] == 'L') {
            curIntVal = 40;
          } else {
            curIntVal = 90;
          }
          i++;
        }
      } else if(curNumeral == 'C') {
        curIntVal = 100;
        if(i < roman.length && (roman[i] == 'D' || roman[i] == 'M')) {
          if(roman[i] == 'D') {
            curIntVal = 400;
          } else {
            curIntVal = 900;
          }
          i++;
        }
      } else if(curNumeral == 'V') {
        curIntVal = 5;
      } else if(curNumeral == 'L') {
        curIntVal = 50;
      } else if(curNumeral == 'D') {
        curIntVal = 500;
      } else if(curNumeral == 'M') {
        curIntVal = 1000;
      }
      if(curIntVal == 0) {
        throw new RuntimeException("Illegal character in roman numeral " + curNumeral);
      }
      res = res + curIntVal;
    }

    return res;
  }

  public static void main(String args[]) {
    RomanToInteger_13 rti = new RomanToInteger_13();
    System.out.println(rti.romanToInt("MCMXCIV"));
  }
}
