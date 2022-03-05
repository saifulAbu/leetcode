package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(points.length, new Comparator<Integer>() {
      @Override
      public int compare(Integer i0, Integer i1) {
        int [] p0 = points[i0];
        int [] p1 = points[i1];
        return (p0[0] * p0[0] + p0[1] * p0[1]) - (p1[0] * p1[0] + p1[1] * p1[1]) ;
      }
    });

    for (int i = 0; i < points.length; i++) {
      pq.offer(i);
    }

    int[][] res = new int[k][];
    for (int i = 0; i < k; i++) {
      res[i] = points[pq.poll()];
    }
    return res;
  }
}
