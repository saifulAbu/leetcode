package contest;

import java.util.*;

public class PayPal {
  public static void main(String args[]) {
    List<String> res = new LinkedList<>();
    res.add("xyz");
    res.add("pqr");
    res.add("cda");
    Comparator<String> c = new Comparator() {
      @Override
      public int compare(Object s0, Object s1) {
        return ((String)s1).compareTo((String) s0);
      }
    };

    Collections.sort(res, c);
    for (String str : res) {
      System.out.println(str);
    }

    PriorityQueue<String> pq = new PriorityQueue<>(c);
    pq.add("p");
    pq.add("a");
    pq.add("z");
    pq.add("r");
    System.out.println("print from priority queue");
    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }
}
