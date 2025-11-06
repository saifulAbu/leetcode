package array_and_string;

public class AddBinary_67 {
  public String addBinary(String a, String b) {
    if(a.length() < b.length()) {
      String t = a;
      a = b;
      b = t;
    }

    a = reverse(a);
    b = reverse(b);


    StringBuilder res = new StringBuilder(a.length() + 1);

    int carry = 0;
    for(int i = 0; i < a.length(); i++) {
      int digitA = a.charAt(i) - '0';
      int digitB = (i < b.length() ? b.charAt(i) - '0' : 0);
      int outDigit = 0;

      switch(digitA + digitB + carry) {
        case 3:
          carry = 1;
          outDigit = 1;
          break;
        case 2:
          carry = 1;
          outDigit = 0;
          break;
        case 1:
          carry = 0;
          outDigit = 1;
          break;
        default:
          carry = 0;
          outDigit = 0;
      }
      res.append(outDigit);
    }
    if(carry == 1) {
      res.append('1');
    }
    return res.reverse().toString();
  }

  private String reverse(String str) {
    char[] arr = str.toCharArray();
    int l = 0;
    int r = arr.length - 1;
    while(l < r) {
      char t = arr[l];
      arr[l] = arr[r];
      arr[r] = t;
      l++;
      r--;
    }
    return new String(arr);
  }




  public String addBinary0(String a, String b) {
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
