package hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
  public boolean isHappy(int n) {
    Set<Integer> seenNums = new HashSet<>();

    while(n != 1) {
        n = getSumOfDigitsSqrd(n);
        if(seenNums.contains(n)) {
          return false;
        }
        seenNums.add(n);
    }

    return true;
  }

  private int getSumOfDigitsSqrd(int num) {
    int sqrSum = 0;
    while(num != 0) {
      int curDigit = num % 10;
      sqrSum += curDigit * curDigit;
      num = num / 10;
    }
    return sqrSum;
  }

  public boolean isHappy0(int n) {
    if(n == 1)
      return true;
    HashSet<Integer> set = new HashSet<>();
    while(!set.contains(n)) {
      set.add(n);
      n = sumSqrDigit(n);
      if(n == 1) {
        return true;
      }
    }
    return false;
  }

  private int sumSqrDigit(int n) {
    int res = 0;
    while(n > 0) {
      int curD = n % 10;
      n /= 10;
      res += curD * curD;
    }
    return res;
  }
}
