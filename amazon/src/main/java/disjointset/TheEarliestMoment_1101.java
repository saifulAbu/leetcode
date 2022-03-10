package disjointset;

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMoment_1101 {
  public int earliestAcq(int[][] logs, int n) {
    Arrays.sort(logs, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return t0[0] - t1[0];
      }
    });
    DisjoinSet disjoinSet = new DisjoinSet(n);
    for (int [] log : logs) {
      int time = log[0];
      int src = log[1];
      int dest = log[2];
      disjoinSet.union(src, dest);
      if (disjoinSet.getNumCompoonents() == 1) {
        return time;
      }
    }
    return -1;
  }
}
