package hash;

import java.util.HashSet;
import java.util.Random;

public class RandomizedSet_380 {
  HashSet<Integer> set = new HashSet<>();

  public boolean insert(int val) {
    if(set.contains(val)) {
      return false;
    } {
      set.add(val);
      return true;
    }
  }

  public boolean remove(int val) {
    if(!set.contains(val)) {
      return false;
    }
    set.remove(val);
    return true;
  }

  public int getRandom() {
    int index = randInt(0, set.size() - 1);
    int i = 0;
    int v = 0;
    for(int val : set) {
      if(i == index) {
        v = val;
        break;
      }
      i++;
    }
    return v;
  }

  public static int randInt(int min, int max) {
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
  }
}
