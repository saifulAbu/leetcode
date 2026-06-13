package leetcode;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {

  public int[][] insert_drona(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = intervals.length;

    // 1. Add all intervals that end before newInterval starts
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    // 2. merge conflicting intervals
    // in the loops logic, just flipped the condition for non conflict
    while(i < n && !(newInterval[1] < intervals[i][0])) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval);

    // 3. Add all intervals that start after newInterval ends
    while (i < n) {
      result.add(intervals[i]);
      i++;
    }

    return result.toArray(new int[result.size()][]);
  }


  public int[][] insert(int[][] intervals, int[] newInterval) {
    LinkedList<int[]> result = new LinkedList<>();

    // add up all the intervals that finishes before newInterval
    int i = 0;
    for(; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if(interval[1] < newInterval[0]) {
        result.addLast(interval);
      } else {
        break;
      }
    }

    if(i == intervals.length) {
     result.addLast(newInterval);
     return result.toArray(new int[result.size()][]);
    }
    // no conflict
    if(intervals[i][0] > newInterval[1]) {
      result.addLast(newInterval);
    } else {
      //there is a conflict
      //merge the intervals
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
      result.addLast(newInterval);
    }


    for(; i < intervals.length; i++) {
      //no conflict
      if(result.getLast()[1] < intervals[i][0]) {
        result.addLast(intervals[i]);
      } else {
        result.getLast()[0] = Math.min(result.getLast()[0], intervals[i][0]);
        result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }

  public int[][] insert_1(int[][] intervals, int[] newInterval) {
    ArrayList<int[]> result = new ArrayList<>();
    int n = intervals.length;
    int i = 0;

    // add up all the intervals ending before new interval
    while(i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i++]);
    }

    // merge conflicting intervals
    // in the loops logic, just flipped the condition for non conflict
    while(i < n && !(newInterval[1] < intervals[i][0])) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }
    //add the new interval
    result.add(newInterval);

    // add the rest
    while(i < n) {
      result.add(intervals[i++]);
    }
    return result.toArray(new int[result.size()][]);
  }
}
