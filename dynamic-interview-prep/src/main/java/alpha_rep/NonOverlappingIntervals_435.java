package alpha_rep;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {
  public int eraseOverlapIntervals(int[][] intervals) {
    /*
    * we sort the intervals based on the end time.
    * as we move on, if we find a conflicting interval, we remove the one that is ending later.
    * [[0, 5], [1, 6], [2, 7], [5, 8]]
    *
    * curEnd = -infinity
    * we check curEnd with [0,5] and update curEnd = 5;
    * then we check [1, 6] with curEnd = 5, because 5 > 1, we would remove this interval
    *
    * */

    //sort based on the end time
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[1] - t1[1];
      }
    });

    // we are going to keep the interval with earlier finish time
    int minIntervalEnd = Integer.MIN_VALUE;
    int minRemoved = 0;

    for(int i = 0; i < intervals.length; i++) {
      int[] curInterval = intervals[i];
      if(minIntervalEnd > curInterval[0]) {
        minRemoved++;
      } else {
        minIntervalEnd = curInterval[1];
      }
    }

    return minRemoved;
  }
}
