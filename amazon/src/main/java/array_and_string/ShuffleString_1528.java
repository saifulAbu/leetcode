package array_and_string;

public class ShuffleString_1528 {
  public String restoreString(String s, int[] indices) {
    int n = indices.length;
    char [] res = new char[n];
    char [] input = s.toCharArray();

    for(int i = 0; i < n; i++) {
      char ch = input[i];
      int j = indices[i];
      res[j] = ch;
    }
    return String.valueOf(res);
  }
}
