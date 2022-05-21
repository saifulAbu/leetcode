package hash;

import java.util.HashSet;

public class HappyNumber_202 {
  public boolean isHappy(int n) {
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
