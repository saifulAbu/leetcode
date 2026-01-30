package math;

public class IsPowerOfThree_326 {
  public boolean isPowerOfThree(int n) {
    double lg = Math.log10(n) / Math.log10(3);
    int intPart = (int) lg;
    if (lg - intPart == 0) {
      return true;
    }
    return false;
  }
}
