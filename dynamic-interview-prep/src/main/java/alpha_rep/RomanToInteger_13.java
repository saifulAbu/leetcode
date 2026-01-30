package alpha_rep;

import java.util.Set;

public class RomanToInteger_13 {

  public int romanToInt(String s) {
    /*
    * we can convert roman single char literals as is, such as I, III, VI, any time we see a I, that translates to 1.
    * except for IV, IX, XL, XC, CD, CM. these 6 special cases. so if we see current character V, X, L, C, D or M,
    * we want to know the character before.
    * for a romanLiteral such as
    * 0 1 2 3 4
    * X X V I I
    *
    * we will start with index 4 and work our way to index 0.
    *
    * */
    char[] romanChars = s.toCharArray();
    Set<Integer> specialCaseVals = Set.of(4, 9, 40, 90, 400, 900);
    int intVal = 0;

    for(int i = romanChars.length - 1; i >= 0; i--) {
      int curDigitVal  = 0;
      char curChar = romanChars[i];

      if(curChar == 'I') {
        curDigitVal = 1;
      } else {
        char charToLookBefore;
        int defaultVal = 0;
        int specialCaseVal = 0;

        if(curChar == 'V') {
          charToLookBefore = 'I';
          defaultVal = 5;
          specialCaseVal = 4;
        } else if(curChar == 'X') {
          charToLookBefore = 'I';
          defaultVal = 10;
          specialCaseVal = 9;
        } else if(curChar == 'L') {
          charToLookBefore = 'X';
          defaultVal = 50;
          specialCaseVal = 40;
        } else if(curChar == 'C') {
          charToLookBefore = 'X';
          defaultVal = 100;
          specialCaseVal = 90;
        } else if(curChar == 'D') {
          charToLookBefore = 'C';
          defaultVal = 500;
          specialCaseVal = 400;
        } else { //if(curChar == 'M')
          charToLookBefore = 'C';
          defaultVal = 1000;
          specialCaseVal = 900;
        }
        curDigitVal = convertToInt(romanChars, i, charToLookBefore, defaultVal, specialCaseVal);
        i = updateI(curDigitVal, i, specialCaseVals);
      }
      intVal += curDigitVal;
    }

    return intVal;
  }

  private int updateI(int curDigitVal, int i, Set<Integer> specialCaseVals) {
    if(specialCaseVals.contains(curDigitVal)) {
      return i - 1;
    }
    return i;
  }

  private int convertToInt(char[] romanChars, int i, char romanLiteralSpecialCase, int defaultVal, int specialCaseVal) {
    if(i-1 >= 0 && romanChars[i-1] == romanLiteralSpecialCase) {
      return specialCaseVal;
    }
    return defaultVal;
  }

  public int romanToInt0(String s) {
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
}
