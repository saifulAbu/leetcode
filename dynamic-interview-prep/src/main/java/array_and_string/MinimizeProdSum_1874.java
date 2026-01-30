package array_and_string;

import java.util.Arrays;

public class MinimizeProdSum_1874 {
  public int minProductSum(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    reverseArray(nums1);
    Arrays.sort(nums2);

    int res = 0;
    for (int i = 0; i < nums1.length; i++) {
      res = res + nums1[i] * nums2[i];
    }
    return res;
  }

  private void reverseArray(int[] nums1) {
    int l = nums1.length - 1;
    for (int i = 0; i < nums1.length / 2; i++) {
      int temp = nums1[i];
      nums1[i] = nums1[l - i];
      nums1[l - i] = temp;
    }
  }
}
