package array_and_string;

public class CountMatches_1688 {
  public int numberOfMatches(int n) {
    int countMatch = 0;

    while(n > 1) {
      if(n % 2 == 0) {
        countMatch += n / 2;
        n = n / 2;
      } else {
        countMatch += (n - 1) / 2 + 1;
        n = (n - 1) / 2;
      }
    }
    return countMatch;
  }
}
