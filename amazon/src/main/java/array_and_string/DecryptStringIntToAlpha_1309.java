package array_and_string;

public class DecryptStringIntToAlpha_1309 {
  public String freqAlphabets(String s) {
    String res = "";
    char[] sarr = s.toCharArray();
    int i = 0;
    while (i < sarr.length) {
      char c;
      if(i + 2 < sarr.length && sarr[i+2] == '#') {
       c = (char) ((sarr[i] - '0') * 10 + (sarr[i+1] - '0') + 'a' - 1);
        i += 3;
      } else {
        c = (char) ((sarr[i] - '0') + 'a' - 1);
        i += 1;
     }
      res += c;
    }
    return res;
  }

  public static void  main(String args[]) {
    DecryptStringIntToAlpha_1309 d = new DecryptStringIntToAlpha_1309();
    System.out.println(d.freqAlphabets("25#"));
  }
}


