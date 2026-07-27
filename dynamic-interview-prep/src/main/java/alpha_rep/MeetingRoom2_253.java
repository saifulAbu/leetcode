package alpha_rep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2_253 {
  public int minMeetingRooms_drona(int[][] intervals) {
    /*
     * My initial idea:
     * - Sort intervals by start time.
     * - Greedily fill one room at a time by adding all non-conflicting intervals.
     * - Move conflicting intervals to a new list and repeat.
     * - This works but is O(n^2) because we rebuild rooms repeatedly.
     * 
     * How this leads to the optimal solution:
     * - For each room, I only need to track the end time of the last meeting.
     * - Instead of building rooms one by one, keep all room end-times in a
     * min-heap.
     * - For each new meeting, reuse the room that frees up earliest (heap top),
     * or allocate a new room if none are free.
     * - Heap size = number of rooms needed.
     * - This reduces the complexity to O(n log n).
     */

    Arrays.sort(intervals, (i0, i1) -> i0[0] - i1[0]);

    PriorityQueue<Integer> roomEndTime = new PriorityQueue<>();

    for (int[] interval : intervals) {
      if (!roomEndTime.isEmpty() && roomEndTime.peek() <= interval[0]) {
        roomEndTime.poll();
      }
      roomEndTime.offer(interval[1]);
    }

    return roomEndTime.size();
  }

  public int minMeetingRooms_1(int[][] intervals) {
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

  public int minMeetingRooms_2(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

    for (int[] interval : intervals) {
      int earliestEndTime = pq.peek();
      // we can reuse this room
      if (interval[0] > earliestEndTime) {
        pq.poll();
      }
      pq.offer(interval[1]);
    }

    return pq.size();
  }

  public int minMeetingRooms_0613(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    for (int[] interval : intervals) {
      if (pq.isEmpty()) {
        pq.offer(interval[1]);
      } else {
        if (pq.peek() <= interval[0]) {
          pq.poll();
        }
        pq.offer(interval[1]);
      }
    }
    return pq.size();
  }

  public int minMeetingRooms_0714(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i = 0; i < intervals.length; i++) {
      int s = intervals[i][0];
      int e = intervals[i][1];

      if(!pq.isEmpty() && pq.peek() <= s) {
        pq.poll();
      } 
      pq.offer(e);
    }

    return pq.size();
  }

  public int test() {
    int my =  30;
    
  }

}
