package math;

public class CountPrimes_204 {
  public int countPrimes(int n) {
    if (n < 2) {
      return 0;
    }
    boolean [] isPrime = new boolean[n];
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i < n; i++) {
      isPrime[i] = true;
    }
    // generate divisors
    for (int divisor = 2; divisor * divisor < n; divisor++) {
      if (isPrime[divisor]) {
        for (int j = divisor * divisor; j < n; j += divisor) {
          isPrime[j] = false;
        }
      }
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (isPrime[i]) {
        count++;
      }
    }
    return count;
  }
}
