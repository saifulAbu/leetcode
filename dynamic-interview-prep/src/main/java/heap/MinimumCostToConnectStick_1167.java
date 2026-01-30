package heap;

import java.util.PriorityQueue;

public class MinimumCostToConnectStick_1167 {
  public int connectSticks(int[] sticks) {
    int cost = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int stick : sticks) {
      pq.offer(stick);
    }
    while (pq.size() > 1) {
      int curCost = pq.poll() + pq.poll();
      cost += curCost;
      pq.offer(curCost);
    }
    return cost;
  }
}
