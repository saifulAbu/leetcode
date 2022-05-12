package trees_and_graphs;

import java.util.HashSet;
import java.util.Set;

public class PathWithMinEffort_1631 {
  int R, C;
  int[] rc = new int[2];
  Set<Integer> inQ = new HashSet<>();

  public int minimumEffortPath(int[][] heights) {
    R = heights.length;
    C = heights[0].length;
  }

  int getId(int r, int c) {
    return r * R + c;
  }

  void getRC(int id) {
    rc[0] = id / R;
    rc[1] = id - rc[0] * R;
  }

  void markInQueue(int id) {
    inQ.add(id);
  }

  void markOutOfQueue(int id) {
    inQ.remove(id);
  }

  boolean isInQ(int id) {
    return inQ.contains(id);
  }

}
