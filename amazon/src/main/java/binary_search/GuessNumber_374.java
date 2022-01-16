package binary_search;

public class GuessNumber_374 {
  public int guessNumber(int n) {
    int l = 1, h = n, m = 0;
    boolean found = false;

    while (l <= h && !found) {
      m = l + (h - l) / 2;
      switch (guess(m)) {
        case 0:
          found = true;
          break;
        case 1:
          l = m + 1;
          break;
        default:
          h = m - 1;
      }
    }
    return m;
  }

  int guess(int num) {
    return 0;
  }
}
