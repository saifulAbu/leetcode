package zystem_design;

import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
  final int MAX_QUEUE_SIZE;
  final int TIME_WINDOW;
  Queue<Integer> requestQueue;

  public RateLimiter(int n, int t) {
    MAX_QUEUE_SIZE = n;
    TIME_WINDOW = t;
    requestQueue = new LinkedList<>();
  }

  public boolean shouldAllow(int timestamp) {
    while(!requestQueue.isEmpty() && requestQueue.peek() < (timestamp - TIME_WINDOW + 1)) {
      requestQueue.poll();
    }
    if(requestQueue.size() < MAX_QUEUE_SIZE) {
      requestQueue.offer(timestamp);
      return true;
    }
    return false;
  }
}
