package alpha_rep;

import java.util.*;

public class MergeIntervals_56 {
  public int[][] merge(int[][] intervals) {
    /*
    * [[7, 10], [4, 6], [1, 3], [2, 5]]
    * first sort the intervals based on the first value
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
}
