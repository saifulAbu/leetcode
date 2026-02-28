package alpha_rep;

import java.util.*;

public class MergeIntervals_56 {
  public int[][] merge(int[][] intervals) {
    /*
    * [[7, 10], [4, 6], [1, 3], [2, 5]]
    * first sort the intervals based on the start time, we do so because in our mergedList, this is the minimum start time we will have
    * [[1, 3], [2, 5], [4, 6], [7, 10]]
    * lets maintain a mergedList = []
    * if it is empty, just add the element in it
    * [[1, 3]]
    * afterward, check if we can merge the next element, [2, 5] with the end of the merged list,
    * [[1, 5]]
    * continue this way.
    * */

    if(intervals.length == 1) {
      return intervals;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      //sort ascending based on t[0]
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[0] - t1[0];
      }
    });

    Deque<int[]> mergedList = new ArrayDeque<>();
    mergedList.add(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] curInterval = intervals[i];
      int[] mergeInterval = mergedList.getLast();
      if(mergeInterval[1] >= curInterval[0]) {
        mergeInterval[1] = Math.max(mergeInterval[1], curInterval[1]);
      } else {
        mergedList.addLast(curInterval);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][]);
  }























  public int[][] merge_1(int[][] intervals) {
    //sort based on start time
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[0] - t1[0];
      }
    });

    LinkedList<int[]> mergedList = new LinkedList<>();
    mergedList.addLast(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] curInterval = intervals[i];
      int [] tailElementOnSortedList = mergedList.getLast();
      if(tailElementOnSortedList[1] >= curInterval[0]) {
        tailElementOnSortedList[1] = Math.max(tailElementOnSortedList[1], curInterval[1]);
      } else {
        mergedList.add(curInterval);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][2]);
  }
}
