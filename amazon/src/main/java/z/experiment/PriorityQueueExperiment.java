package z.experiment;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
* testing priority queue of string.
* there is a map with count of words
* [ a => 2, b => 2, ab => 5, z => 2]
* priority queue will return the most frequent first [ab => 5]
* if there is a tie [a, b, z] it will return the one that come the late in the dictionary
* so it will return [z, b, a]
*
* */
public class PriorityQueueExperiment {

  String [] word = {"a", "b", "ab", "z"};
  int[] freq = {2, 2, 5, 2};

  HashMap<String, Integer> map = new HashMap<>();

  class MapElemComparator implements Comparator<String> {
    @Override
    public int compare(String s0, String s1) {
      int freqDiff = map.get(s1) - map.get(s0);
      if(freqDiff == 0) {
        return s1.compareTo(s0);
      } else {
        return freqDiff;
      }
    }
  }

  PriorityQueue<String> pq = new PriorityQueue<>(new MapElemComparator());

  public PriorityQueueExperiment() {
    //fill up the map
    for(int i = 0; i < word.length; i++) {
      map.put(word[i], freq[i]);
    }

    // fill up the queue
    for(String word : map.keySet()) {
      pq.offer(word);
    }
  }

  public void testRetrieval() {
    while(!pq.isEmpty()) {
      String cur = pq.poll();
      System.out.println(cur + " : " + map.get(cur));
    }
  }

}
