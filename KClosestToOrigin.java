package alpha_rep;

import java.util.PriorityQueue;

public class KClosestToOrigin {
  class QueueElement implements Comparable<QueueElement> {
    int[] point;
    int distance;

    QueueElement(int[] point, int distance) {
      this.point = point;
      this.distance = distance;
    }

    @Override
    public int compareTo(QueueElement o) {
      return o.distance - this.distance;
    }
  }

  PriorityQueue<QueueElement> queue;
  private int maxQueueSize = 0;

  public int[][] kClosest(int[][] points, int K) {
    int[][] result = new int[K][];
    maxQueueSize = K;
    queue = new PriorityQueue<>(K);

    for (int[] point : points) {
      int distance = point[0] * point[0] + point[1] * point[1];
      if (queue.size() < maxQueueSize) {
        queue.add(new QueueElement(point, distance));
      } else {
        if (distance < queue.peek().distance) {
          queue.poll();
          queue.add(new QueueElement(point, distance));
        }
      }
    }

    for (int i = 0; i < K; i++) {
      QueueElement elem = queue.poll();
      result[i] = elem.point;
    }

    return result;
  }

  public static void main(String args[]) {
    KClosestToOrigin soln = new KClosestToOrigin();
    int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
    int K = 2;
    int[][] result = soln.kClosest(points, K);
    return;
  }

  public int[][] kClosest_0714(int[][] points, int k) {
    // max heap
    PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

    for (int i = 0; i < points.length; i++) {
      int[] cur = points[i];
      double dist = Math.sqrt(cur[0] * cur[0] + cur[1] * cur[1]);
      double[] curEntry = { i, dist };
      if (pq.size() < k) {
        pq.offer(curEntry);
      } else {
        if (pq.peek()[1] > dist) {
          pq.poll();
          pq.offer(curEntry);
        }
      }
    }

    int[][] res = new int[k][2];
    for (int i = 0; i < k; i++) {
      res[i] = points[pq.poll()[0]];
    }

    return res;
  }

  public int[][] kClosest_drona(int[][] points, int k) {
    // Max-heap comparing squared Euclidean distances: (x1^2 + y1^2) vs (x2^2 +
    // y2^2)
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])));

    for (int[] point : points) {
      pq.offer(point);
      if (pq.size() > k) {
        pq.poll(); // Evicts the furthest point currently in the heap
      }
    }

    int[][] res = new int[k][2];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }

    return res;
  }
}
