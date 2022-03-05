package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement_215 {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
      pq.add(num);
    }

    for (int i = 0; i < k - 1; i++) {
      pq.remove();
    }

    return pq.peek();
  }
}
