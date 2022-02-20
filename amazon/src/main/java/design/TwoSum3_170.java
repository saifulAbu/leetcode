package design;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum3_170 {
  int size = 0;
  ArrayList<Integer> list;
  HashMap<Integer, Integer> map;
  public TwoSum3_170() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public void add(int number) {
    map.put(number, size++);
    list.add(number);
  }

  public boolean find(int value) {
    for (int i = 0; i < size; i++) {
      if(map.getOrDefault(value - list.get(i), 0) > i) {
        return true;
      }
    }
    return false;
  }
}
