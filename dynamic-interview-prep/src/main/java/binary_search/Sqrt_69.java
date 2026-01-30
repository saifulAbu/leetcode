package binary_search;

public class Sqrt_69 {
  static public int mySqrt(int x) {
    if (x < 2) return x;
    long sqr0, sqr1;
    int l = 0, r = x;
    while (l <= r) {
      int m = l + (r - l) / 2;
      sqr0 = (long)m * m; //do deal with overflow
      long sqq0 = (long)m * m;
      sqr1 = ((long)(m+1)) * (m + 1); //to deal with overflow
      long sqq1 = ((long)(m+1)) * (m + 1); //to deal with overflow
      if (sqr0 <= x && x < sqr1 ) {
        return m;
      } else if (sqr0 > x) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return r;
  }

  public static void main(String args[]) {
    mySqrt(2147395599);
  }
}
