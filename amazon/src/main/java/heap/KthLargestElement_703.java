package heap;

import java.util.PriorityQueue;

public class KthLargestElement_703 {
  int k;
  PriorityQueue<Integer> pq = new PriorityQueue<>();
  public KthLargestElement_703(int k, int[] nums) {
    this.k = k;
    for (int n : nums) {
      pq.add(n);
    }
    while (pq.size() > k) {
      pq.poll();
    }
  }

  public int add(int val) {
    pq.add(val);
    while (pq.size() > k) {
      pq.poll();
    }
    return pq.peek();
  }
}
