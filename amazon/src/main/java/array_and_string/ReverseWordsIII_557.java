package array_and_string;

public class ReverseWordsIII_557 {
  public String reverseWords(String s) {
    char[] in = s.toCharArray();
    char[] res = new char[s.length()];
    int l = 0, h = 0;
    int len = res.length;
    int k = 0;
    while (k < len) {
      // copy all  space to result
      while (h < len && in[h]==' ') {
        res[k++] = in[h++];
      }
      // now seeing no space character, set lower limit
      l = h;

      //find upper limit of non-space character
      while (h < len && in[h]!=' ') {
        h++;
      }
      // when h moved out of the loop, it got added once by h++, reset that to temp variable
      int t = h - 1;
      //copy non-space characters backward to result
      while (t >= l) {
        res[k++] = in[t--];
      }
    }
    return new String(res);
  }
}
