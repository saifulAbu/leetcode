package array_and_string;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {
  public boolean canAttendMeetings(int[][] intervals) {
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
