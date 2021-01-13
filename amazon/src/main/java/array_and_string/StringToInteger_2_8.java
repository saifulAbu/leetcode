package array_and_string;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/

public class StringToInteger_2_8 {
  public int myAtoi(String s) {
    int res = 0;

    int maxValidNumericStringLen = 10; //max part len without the + or - sign

    char[] digits = s.toCharArray();
    int i = 0;
    //ignore leading white space
    while(digits[i] == ' ') {
      i++;
    }
    if(i == digits.length) {
      return res;
    }

    int sign = 1;
    if(digits[i] == '-') {
      sign = -1;
      i++;
    } else if(digits[i] == '+') {
      sign = 1;
      i++;
    }

    if(i == digits.length) {
      return res;
    }

    int digitCount = 0;
    int maxDigit = (int) Math.ceil(Math.log10(Math.pow(2, 31) - 1));

    while(Character.isDigit(digits[i])) {
      res = res * 10 + (digits[i] - '0');
    }

    return res;
  }

  public static void main(String [] args) {
    StringToInteger_2_8 sol = new StringToInteger_2_8();
    int res = sol.myAtoi("19");
    System.out.println(res);
  }
}
