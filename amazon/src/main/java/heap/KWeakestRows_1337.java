package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRows_1337 {
  public int[] kWeakestRows(int[][] mat, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] c0, int[] c1) {
        if (c0[0] == c1[0]) {
          return c0[0] - c1[0];
        }
        return c0[1] - c1[1];
      }
    });

    for (int i = 0; i < mat.length; i++) {
      pq.add(new int[] {i, countOne(mat[i])});
    }

    int [] ret = new int[k];
    int i = 0;
    while (!pq.isEmpty() && k > 0) {
      ret[i++] = pq.poll()[0];
      k--;
    }
    return ret;
  }

  private int countOne(int [] soldier) {
    int count = 0;
    for (int cur : soldier) {
      if (cur == 1) {
        count++;
      }
    }
    return count;
  }
}
