package binary_search;

public class FirstBadVersion_278 {
  public int firstBadVersion(int n) {
    int l = 1, h = n;
    while (l <= h) {
      int m = l + (h - l) / 2;
      boolean curIsBad = isBadVersion(m);
      if (curIsBad) {
        boolean prevIsBad = false;
        if (m - 1 >= 0) {
          prevIsBad = isBadVersion(m-1);
        }
        if (!prevIsBad) {
          return m;
        }
        h = m - 1;
      } else {
        boolean nextIsBad = true;
        if (m + 1 <= n) {
          nextIsBad = isBadVersion(m + 1);
        }
        if (nextIsBad) {
          return m + 1;
        }
        l = m + 1;
      }
    }
    return -1;
  }

  boolean isBadVersion(int version) {
    return false;
  }
}
