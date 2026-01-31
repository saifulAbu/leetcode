package alpha_rep;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {
  public boolean canAttendMeetings(int[][] intervals) {
    /*
    * [[1, 2], [3, 4], [5, 6]]
    * above is a valid interval, prev[1] < cur[0].
    *
    * so we can sort the interval array based on the first element. then using a for loop, we can check if the above
    * property hold for all elements.
    *
    * */

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] i0, int[] i1) {
        return i0[0] - i1[0];
      }
    });

    if(intervals.length == 1) {
      return true;
    }

    for(int i = 1; i < intervals.length; i++) {
      int[] prev = intervals[i-1], cur = intervals[i];
      // an example [[1, 5], [2, 4]]
      if(prev[1] > cur[0]) {
        return false;
      }
    }
    return true;
  }

  public boolean canAttendMeetings_0(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] arr0, int[] arr1) {
        return arr0[0] - arr1[0];
      }
    });
    for (int i = 0; i < intervals.length - 2; i++) {
      int [] cur = intervals[i];
      int [] next = intervals[i+1];
      if (cur[1] > next[0]) {
        return false;
      }

    }
    return true;
  }
}
