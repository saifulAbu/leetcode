package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
  PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer i0, Integer i1) {
      return i1 - i0;
    }
  });

  public int lastStoneWeight(int[] stones) {
    for (int stone : stones) {
      pq.add(stone);
    }

    while (pq.size() > 1) {
      int y = pq.poll();
      int x = pq.poll();
      if (y - x > 0) {
        pq.add(y-x);
      }
    }
    return pq.isEmpty()? 0 : pq.poll();
  }

  public static void main(String[] args) {
    LastStoneWeight_1046 ls = new LastStoneWeight_1046();
    int[] abs = {2,7,4,1,8,1};
    ls.lastStoneWeight(abs);
  }
}
