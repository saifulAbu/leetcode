package alpha_rep;

import java.util.ArrayList;
import java.util.Collections;

public class FindMedianDataStream_295 {
  /*
  * we will use a sorted arraylist. for amortized analysis, access time is O(1) because arrayList is backed by an array
  * when a new number comes, we will look it up using binary search. logN time. insert using O(n) time
  * insert is O(N + logN) ~ O(N)
  *
  * to retrieve, do it in O(1). our aray is sorted. so just pick up the proper value
  * */
  ArrayList<Integer> nums = new ArrayList<>();

  public void addNum(int num) {
    int insertIndex = Collections.binarySearch(nums, num);
    if(insertIndex < 0) {
      insertIndex = Math.abs(insertIndex + 1); // for non_existing element, binary Search returns ,( -1 * insertIndex - 1)
    }
    nums.add(insertIndex, num);
  }

  public double findMedian() {
    int medianIndex = nums.size() / 2;
    double median = nums.get(medianIndex);
    if(nums.size() % 2 == 0) {
      median = (nums.get(medianIndex-1) + nums.get(medianIndex)) / 2.0;
    }
    return median;
  }
}
