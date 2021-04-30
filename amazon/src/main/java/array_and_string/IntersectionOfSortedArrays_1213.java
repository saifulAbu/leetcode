package array_and_string;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays_1213 {
  public List<Integer> arraysIntersection(int[] arr0, int[] arr1, int[] arr2) {
    List<Integer> result = new ArrayList<>();
    int ptr0, ptr1, ptr2;
    ptr0 = ptr1 = ptr2 = 0;

    while (
        ptr0 < arr0.length &&
        ptr1 < arr1.length &&
        ptr2 < arr2.length
    ) {
      if (arr0[ptr0] == arr1[ptr1] && arr1[ptr1] == arr2[ptr2]) {
        result.add(arr0[ptr0]);
        ptr0++;
        ptr1++;
        ptr2++;
      } else if(arr0[ptr0] < arr1[ptr2]) {
        ptr0++;
      } else if (arr0[ptr1] < arr1[ptr2]) {
        ptr1++;
      } else {
        ptr2++;
      }
    }
    return result;
  }
}
