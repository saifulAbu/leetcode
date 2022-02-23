package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer n0, Integer n1) {
        return count.get(n1) - count.get(n0);
      }
    });
    for (int key : count.keySet()) {
      pq.add(key);
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }
    return res;
  }
}
