package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinIndexSum_599 {
  public String[] findRestaurant(String[] list0, String[] list1) {
    int minSum = Integer.MAX_VALUE;
    HashMap<String, Integer> mapList0 = formMapIndex(list0);
    ArrayList<String> resList = new ArrayList<>();
    for(int i = 0; i < list1.length; i++) {
      String curStr = list1[i];
      if(!mapList0.containsKey(curStr)) {
        continue;
      }
      int curSum = i + mapList0.get(curStr);
      if(curSum < minSum) {
        resList.clear();
        resList.add(curStr);
        minSum = curSum;
      } else if (curSum == minSum) {
        resList.add(curStr);
      }
    }
    return resList.toArray(new String[resList.size()]);
  }

  HashMap<String, Integer> formMapIndex(String [] list) {
    HashMap<String, Integer> map = new HashMap<>();
    for(int i = 0; i < list.length; i++) {
      map.put(list[i], i);
    }
    return map;
  }
}
