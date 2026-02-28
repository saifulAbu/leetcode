package binary_search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindKClosest_658 {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    /*
    * we create a binarySearch variation that returns the insert index of an element if the element does not exits in
    * the array. if it is there, it returns the index of the element
    *
    * then we create 2 pointers, h = insert_index, l = h - 1 (this is to favor smaller elements)
    * we expand h and l and continue taking elements
    * */
    int insertIndex = binarySearch(arr, x);
    int l = insertIndex - 1, h = insertIndex;

    LinkedList<Integer> result = new LinkedList<>();
    int len = arr.length, need = k;
    //one of the pointers are valid and we still need element to insert to our list
    while((l >= 0 || h < len) && need > 0) {
      if(l < 0) {
        result.addLast(arr[h++]);
      } else if(h >= len) {
        result.addFirst(arr[l--]);
      } else {
        if(Math.abs(x - arr[l]) <= Math.abs(x - arr[h])) {
          result.addFirst(arr[l--]);
        } else {
          result.addLast(arr[h++]);
        }
      }
      need--;
    }
    return result;
  }

  private int binarySearch(int[] arr, int k) {
    int l = 0, h = arr.length - 1;
    while(l <= h) {
      int m = l + (h - l) / 2;
      if(arr[m] == k) {
        return m;
      } else if(arr[m] < k) {
        l = m + 1;
      } else {
        h = m - 1;
      }
    }
    return l;
  }

  public List<Integer> findClosestElements_0(int[] arr, int k, int x) {
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
