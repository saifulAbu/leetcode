package array_and_string;

import java.util.Arrays;

public class IntersectionOfArrays2_350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int resSize = 0;
    int i = 0, j = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        i++;
      } else if(nums1[i] > nums2[j]) {
        j++;
      } else {
        nums1[resSize++] = nums1[i];
        i++;
        j++;
      }
    }
    return Arrays.copyOfRange(nums1, 0, resSize);
  }
}
