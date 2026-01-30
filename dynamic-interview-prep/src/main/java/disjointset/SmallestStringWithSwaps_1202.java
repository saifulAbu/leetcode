package disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestStringWithSwaps_1202 {
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    DisjoinSet ds = new DisjoinSet(s.length());
    for (List<Integer> pair : pairs) {
      ds.union(pair.get(0), pair.get(1));
    }

    HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int setId = ds.find(i);
      if (!map.containsKey(setId)) {
        map.put(setId, new PriorityQueue<>());
      }
      map.get(setId).offer(s.charAt(i));
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(map.get(ds.find(i)).poll());
    }
    return sb.toString();
  }
}
