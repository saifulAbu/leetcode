package hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
  public int[] intersection(int[] nums1, int[] nums2) {
    int[] small = nums1, big = nums2;
    if(small.length > big.length) {
      small = nums2;
      big = nums1;
    }
    Set<Integer> smallSet = new HashSet<>();
    for(int num : small) {
      smallSet.add(num);
    }

    Set<Integer> resultSet = new HashSet<>();
    for(int num : big) {
      if(smallSet.contains(num)) {
        resultSet.add(num);
      }
    }

    int[] res = new int[resultSet.size()];
    int i = 0;
    for(int num : resultSet) {
      res[i++] = num;
    }
    return res;
  }

  public int[] intersection0(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      int[] t = nums1;
      nums1 = nums2;
      nums2 = t;
    }
    HashSet<Integer> s1 = new HashSet<>();
    for (int num : nums1) {
      s1.add(num);
    }
    HashSet<Integer> res = new HashSet<>();
    for (int num : nums2) {
      if (s1.contains(num)) {
        res.add(num);
      }
    }

    int [] r = new int[res.size()];
    int i = 0;
    Iterator<Integer> itr = res.iterator();
    while (itr.hasNext()) {
      r[i++] = itr.next();
    }
    return r;
  }
}
