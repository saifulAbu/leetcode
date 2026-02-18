package alpha_rep;

import java.util.Map;
import java.util.TreeMap;

public class CarPool_1094 {
  public boolean carPooling(int[][] trips, int capacity) {
    /*
    * people = trip[0], start = trip[1], end = trip[2]
    *
    * we will use a treeMap, sorted ascending way based on timeStamp
    * at time stamp of start, we are having +people
    * at time stamp for end, we are having -people
    *
    * we will continue through the treemap and add up the people counts
    * at any point if it exceeds capacity, return false;
    *
    * */

    TreeMap<Integer, Integer> timeStampMap = new TreeMap<>();
    for(int[] trip : trips) {
      int people = trip[0], start = trip[1], end = trip[2];
      timeStampMap.put(start, timeStampMap.getOrDefault(start, 0) + people);
      timeStampMap.put(end, timeStampMap.getOrDefault(end, 0) - people);
    }

    int curPeople = 0;
    for(int peopleChange : timeStampMap.values()) {
      curPeople += peopleChange;
      if(curPeople > capacity) {
        return false;
      }
    }
    return true;
  }
}
