package array_and_string;

public class ReadNChars_157 {
  public int read(char[] buf, int n) {
    char [] buf4 = new char[4];
    int i = 0;
    int remaining = n;
    while (remaining > 0) {
      int k = read4(buf4);
      for (int p = 0; p < k && remaining > 0; p++) {
        buf[i++] = buf4[p];
        remaining--;
      }
      if (k < 4) {
        break;
      }
    }
    return i;
  }

  int read4(char[] buf4) {
    return 3;
  }
}
