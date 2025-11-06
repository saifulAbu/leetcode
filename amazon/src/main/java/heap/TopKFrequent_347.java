package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TopKFrequent_347 {

  private HashMap<Integer, Integer> createHistogram (int[] nums) {
    HashMap<Integer, Integer> histogram = new HashMap<>();
    for(int num : nums) {
      histogram.put(num, (histogram.getOrDefault(num, 0) + 1));
    }
    return histogram;
  }

  private HashMap<Integer, LinkedList<Integer>> createReverseHistogram(HashMap<Integer, Integer> histogram) {
    HashMap<Integer, LinkedList<Integer>> reverseHistogram = new HashMap<>();

    for(int num : histogram.keySet()) {
      int count = histogram.get(num);
      if(!reverseHistogram.containsKey(count)) {
        reverseHistogram.put(count, new LinkedList<>());
      }
      reverseHistogram.get(count).add(num);
    }
    return reverseHistogram;
  }

  private int[] getTopKFrequent(HashMap<Integer, LinkedList<Integer>> reverseHistogram, int len, int k) {
    int[] topK = new int[k];
    for(int count = len; count > 0; count--) {
      if(reverseHistogram.containsKey(count)) {
        LinkedList<Integer> nums = reverseHistogram.get(count);
        for(int num : nums) {
          k--;
          if(k < 0) {
            break;
          }
          topK[k] = num;
        }
      }
      if(k < 0) {
        break;
      }
    }
    return topK;
  }

  public int[] topKFrequent(int[] nums, int k) {
    return getTopKFrequent(createReverseHistogram(createHistogram(nums)), nums.length, k);
  }



  /******************************************************************************/
  public int[] topKFrequent0(int[] nums, int k) {
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
