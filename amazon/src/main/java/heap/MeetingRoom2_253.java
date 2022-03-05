package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2_253 {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[0] - t1[0];
      }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      int curStartTime = intervals[i][0];
      int curEndTime = intervals[i][1];
      if (pq.peek() <= curStartTime) {
        pq.poll();
      }
      pq.offer(curEndTime);
    }

    return pq.size();
  }
}
