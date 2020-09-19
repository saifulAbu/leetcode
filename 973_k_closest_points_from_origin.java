package com.company;

import java.util.PriorityQueue;

public class KClosestToOrigin {
  class QueueElement implements Comparable<QueueElement> {
    int [] point;
    int distance;

    QueueElement(int [] point, int distance) {
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
    int [][] result = new int[K][];
    maxQueueSize = K;
    queue = new PriorityQueue<>(K);

    for(int[] point : points) {
      int distance = point[0] * point[0] + point[1] * point[1];
      if(queue.size() < maxQueueSize) {
        queue.add(new QueueElement(point, distance));
      } else {
        if(distance < queue.peek().distance) {
          queue.poll();
          queue.add(new QueueElement(point, distance));
        }
      }
    }

    for(int i = 0; i < K; i++) {
      QueueElement elem = queue.poll();
      result[i] = elem.point;
    }

    return result;
  }

  public static void main(String args[]) {
    KClosestToOrigin soln = new KClosestToOrigin();
    int [][] points = { {3,3}, {5,-1}, {-2,4}};
    int K = 2;
    int[][] result = soln.kClosest(points, K);
    return;
  }
}

