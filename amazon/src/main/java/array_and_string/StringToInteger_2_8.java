package array_and_string;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/

public class StringToInteger_2_8 {
  public int myAtoi(String s) {
    int res = 0;

    char[] num = s.toCharArray();
    int i = 0;
    while(i < num.length && num[i] == ' ') {
      i++;
    }
    int sign = 1;
    if(i < num.length && (num[i] == '+' || num[i] == '-')) {
      if(num[i++] == '+') {
        sign = 1;
      } else {
        sign = -1;
      }
    }

    while(i < num.length && Character.isDigit(num[i])) {
      int curDigit = num[i++] - '0';
      if(res > Integer.MAX_VALUE / 10
              || (res == Integer.MAX_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10)
      ) {
        return (sign == 1) ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      res = res * 10 + curDigit;
    }

    return res * sign;
  }

  public static void main(String [] args) {
    StringToInteger_2_8 sol = new StringToInteger_2_8();
    int res = sol.myAtoi("42");
    System.out.println(res);
  }
}
