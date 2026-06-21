package alpha_rep;

import java.util.*;

public class MergeIntervals_56 {

  public int[][] merge_drona(int[][] intervals) {
    //sort by start time
    Arrays.sort(intervals,
            (a, b) -> a[0] - b[0]
    );

    ArrayList<int[]> result = new ArrayList<>();
    int[] lastInsertedInterval = null;

    for(int[] interval : intervals) {
      if(lastInsertedInterval == null) {
        result.add(interval);
        lastInsertedInterval = interval;
      } else {
        if(lastInsertedInterval[1] >= interval[0]) {
          lastInsertedInterval[1] = Integer.max(interval[1], lastInsertedInterval[1]);
        } else {
          result.add(interval);
          lastInsertedInterval = interval;
        }
      }
    }

    return result.toArray(new int[result.size()][]);

  }

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


  public int[][] merge_2(int[][] intervals) {

    //sort based on the start time
    Arrays.sort(intervals, (i0, i1) -> i0[0] - i1[0]);

    LinkedList<int[]> mergedList = new LinkedList<>();

    for(int[] interval : intervals) {
      if(mergedList.isEmpty()) {
        mergedList.addLast(interval);
      } else if(interval[0] <= mergedList.getLast()[1]) {
        mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
      } else {
        mergedList.addLast(interval);
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

  public int[][] merge_0529(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[0] - t1[0];
      }
    });

    List<int[]> mergedList = new ArrayList<>();
    mergedList.add(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] cur = intervals[i];
      int[] last = mergedList.get(mergedList.size()-1);
      if(last[1] >= cur[0]) {
        last[1] = Math.max(last[1], cur[1]);
      } else {
        mergedList.add(cur);
      }
    }

    return mergedList.toArray(new int[mergedList.size()][2]);
  }

  public int[][] merge_0613(int[][] intervals) {
    if(intervals == null || intervals.length == 0) {
      return null;
    }

    Arrays.sort(intervals, (arg0, arg1) -> Integer.compare(arg0[0], arg1[0]));

    List<int[]> mergedList = new ArrayList<>();
    mergedList.add(intervals[0]);

    for(int i = 1; i < intervals.length; i++) {
      int[] newInterval = intervals[i];
      int[] lastInsertedInterval = mergedList.getLast();
      if(newInterval[0] <= lastInsertedInterval[1]) {
        lastInsertedInterval[1] = Math.max(lastInsertedInterval[1], newInterval[1]);
      } else {
        mergedList.add(newInterval);
      }
    }
    return mergedList.toArray(new int[mergedList.size()][2]); 
  }
}
