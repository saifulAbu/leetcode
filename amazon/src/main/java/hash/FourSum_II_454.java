package hash;

import java.util.HashMap;
import java.util.Map;

public class FourSum_II_454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    return getPossibleZero(getSumMap(nums1, nums2), getSumMap(nums3, nums4));
  }

  private int getPossibleZero(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
    if(a.size() > b.size()) {
      Map temp = a;
      a = b;
      b = (HashMap<Integer, Integer>) temp;
    }

    int totalSum = 0;
    for(int k : a.keySet()) {
      totalSum += (a.get(k) * b.getOrDefault(-1 * k, 0));
    }
    return totalSum;
  }

  private HashMap<Integer, Integer> getSumMap(int [] a, int[] b) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < a.length; i++) {
      for(int j = 0; j < b.length; j++) {
        int curSum = a[i] + b[j];
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
      }
    }
    return map;
  }

  ///////**************///////
  public int fourSumCount0(int[] l0, int[] l1, int[] l2, int[] l3) {
    return getZeroCount(getSumCount(l0, l1), getSumCount(l2, l3));
  }

  HashMap<Integer, Integer> getSumCount(int[] l0, int [] l1) {
    HashMap<Integer, Integer> res = new HashMap<>();
    for(int i = 0; i < l0.length; i++) {
      for(int j = 0; j < l1.length; j++) {
        int curSum = l0[i] + l1[j];
        res.put(curSum, res.getOrDefault(curSum, 0) + 1);
      }
    }
    return res;
  }

  int getZeroCount(HashMap<Integer, Integer> s0, HashMap<Integer, Integer> s1) {
    int count = 0;
    for(int k0 : s0.keySet()) {
      for(int k1 : s1.keySet()) {
        if(k0+k1 == 0) {
          count += (s0.get(k0) * s1.get(k1));
        }
      }
    }
    return count;
  }
}
