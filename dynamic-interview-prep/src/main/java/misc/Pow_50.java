package misc;

public class Pow_50 {
  public double myPow(double x, int n) {
    if(n == 0) {
      return 1;
    }
    if(n == 1) {
      return x;
    }
    if(n == -1) {
      return 1 / x;
    }

    double res = myPow(x, n/2);
    res *= res;

    if(n % 2 != 0) {
      if(n < 0) {
        res = res /x;
      } else {
        res = res * x;
      }
    }
    return res;
  }
}
