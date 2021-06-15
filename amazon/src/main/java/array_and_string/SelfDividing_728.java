package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class SelfDividing_728 {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> l = new ArrayList<>();
    for(int i = left; i <= right; i++) {
      if(isSelfDividing(i)) {
        l.add(i);
      }
    }
    return l;
  }

  private boolean isSelfDividing(int num) {
    int cpy = num;
    while(cpy > 0) {
      int curDigit = cpy % 10;
      if(curDigit == 0 || !(num % curDigit == 0)) {
        return false;
      }
      cpy /= 10;
    }
    return true;
  }
}
