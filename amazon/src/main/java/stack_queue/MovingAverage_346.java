package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage_346 {
  Queue<Integer> q = new LinkedList<>();
  final int size;
  double sum = 0;
  public MovingAverage_346(int size) {
    this.size = size;
  }

  public double next(int val) {
    if (q.size() == size) {
      sum -= q.poll();
    }
    sum += val;
    q.offer(val);
    return sum / q.size();
  }
}
