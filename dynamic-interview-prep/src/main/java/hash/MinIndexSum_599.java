package hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class MinIndexSum_599 {
  public String[] findRestaurant(String[] list1, String[] list2) {
    // there will be at least one common string
    String[] smallArr, bigArr;
    if(list1.length < list2.length) {
      smallArr = list1;
      bigArr = list2;
    } else {
      smallArr = list2;
      bigArr = list1;
    }

    HashMap<String, Integer> smallMap = new HashMap<>();
    for(int i = 0; i < smallArr.length; i++) {
      smallMap.put(smallArr[i], i);
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < bigArr.length; i++) {
      String curWord = bigArr[i];
      if(!smallMap.containsKey(curWord)) {
        continue;
      }
      int curMin = smallMap.get(curWord) + i;
      min = curMin < min ? curMin : min;
    }

    LinkedList<String> resultList = new LinkedList<>();
    for(int i = 0; i < bigArr.length && (i <= min); i++) {
      String curWord = bigArr[i];
      if(!smallMap.containsKey(curWord)) {
        continue;
      }
      int curMin = smallMap.get(curWord) + i;
      if(curMin > min) {
        continue;
      }
      resultList.add(curWord);
    }
    return resultList.toArray(new String[resultList.size()]);
  }

  public String[] findRestaurant0(String[] list0, String[] list1) {
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
