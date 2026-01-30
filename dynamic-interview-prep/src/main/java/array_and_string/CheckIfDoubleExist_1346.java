package array_and_string;

import java.util.HashSet;

public class CheckIfDoubleExist_1346 {

  public boolean checkIfExist(int[] arr) {
    HashSet<Integer> numSet = new HashSet<>();

    for(int num : arr) {
      if(numSet.contains(num * 2) || ((num % 2 == 0) && numSet.contains(num / 2))) {
        return true;
      }
      numSet.add(num);
    }
    return false;
  }

  public boolean checkIfExist0(int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for(int num : arr) {
      if (set.contains(2 * num)) {
        return true;
      }
      if (num % 2 == 0) {
        if (set.contains(num / 2)) {
          return true;
        }
      }
      set.add(num);
    }
    return false;
  }
}
