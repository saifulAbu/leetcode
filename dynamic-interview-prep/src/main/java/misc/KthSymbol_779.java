package misc;

public class KthSymbol_779 {
  public int kthGrammar(int n, int k) {
    n = n -1;
    k = k - 1;
    return helper(n, k);
  }

  private int helper(int n, int k) {
    if(n == 0) {
      return 0;
    }
    int parentBit = helper(n-1, k / 2);
    if (parentBit == 0) {
      if (k % 2 == 0) {
        return 0;
      } else {
        return 1;
      }
    } else {
        if (k % 2 == 0) {
          return 1;
        } else {
          return 0;
        }
    }
  }
}
