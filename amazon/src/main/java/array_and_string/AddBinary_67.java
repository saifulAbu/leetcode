package array_and_string;

public class AddBinary_67 {
  public String addBinary(String a, String b) {
    String res = "";
    String l, s;
    if(a.length() > b.length()) {
      l = a;
      s = b;
    } else {
      l = b;
      s = a;
    }

    l = new StringBuilder(l).reverse().toString();
    s = new StringBuilder(s).reverse().toString();
    int carry = 0;
    for(int i = 0; i < l.length(); i++) {
      int d0 = l.charAt(i) - '0';
      int d1 = 0;
      if(i < s.length()) {
        d1 = s.charAt(i) - '0';
      }
      int curSum = d0 + d1 + carry;
      int curdigit = 0;
      switch (curSum) {
        case 3:
          carry = 1;
          curdigit = 1;
          break;
        case 2:
          carry = 1;
          curdigit = 0;
          break;
        case 1:
          carry = 0;
          curdigit = 1;
          break;
        default:
          carry = 0;
          curdigit = 0;
      }
      res = curdigit + res;
    }
    if (carry == 1) {
      res = "1" + res;
    }

    return res;
  }


}

// Dummy
// Dummy
// Dummy
// Dummy
