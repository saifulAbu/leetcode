package binary_search;

import java.util.LinkedList;
import java.util.List;

public class FindKClosest_658 {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> list = new LinkedList<>();
    int l = 0, h = arr.length - k;
    while (l < h) {
      int m = l + (h - l) / 2;
      if (x <= arr[m]) {
        h--;
      } else if (arr[m] < x && x < arr[m+k]) {
        if (x - arr[m] <= arr[m+k] - x) {
          h--;
        } else {
          l++;
        }
      } else {
        l++;
      }
    }
    for (int i = l; i < l + k; i++) {
      list.add(arr[i]);
    }

    return list;
  }
}
