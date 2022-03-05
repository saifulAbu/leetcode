package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallestElement_378 {
  public static int kthSmallest(int[][] matrix, int K) {
    int k = 0;
    final int C = matrix[0].length;
    int queueCapacity = Math.min(K, matrix.length);
    PriorityQueue<int[]> pq = new PriorityQueue<>(queueCapacity, new Comparator<int[]>() {
      @Override
      public int compare(int[] t0, int[] t1) {
        return matrix[t0[0]][t0[1]] - matrix[t1[0]][t1[1]];
      }
    });
    for (int r = 0; r < queueCapacity; r++) {
      pq.offer(new int[] {r, 0});
    }
    int curMin = 0;
    while (k != K) {
      int [] cur = pq.poll();
      curMin = matrix[cur[0]][cur[1]];
      if (cur[1] < C - 1) {
      //  System.out.println("offering " + cur[0] + " " + (cur[1] + 1));
        pq.offer(new int[] {cur[0], cur[1] + 1});
      }
      k++;
    }
    return curMin;
  }

  public static void main(String [] args) {
    int [][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
    int k = 8;
    System.out.println(kthSmallest(matrix, k));
  }
}
