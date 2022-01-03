package sorting_searching;

public class SortArray_912 {
  public int[] sortArray(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int[] mergeSort(int[] nums, int l, int h) {
    if (l == h) {
      return new int[] {nums[l]};
    }
    int mid = l + (h - l) / 2;
    return merge(mergeSort(nums, l, mid), mergeSort(nums,mid+1, h));
  }

  private int[] merge(int[] arr0, int[] arr1) {
    int len0 = arr0.length;
    int len1 = arr1.length;
    int i0 = 0, i1 = 0;
    int[] res = new int[len0 + len1];
    int rI = 0;
    while (i0 < len0 && i1 < len1) {
      res[rI++] = arr0[i0] < arr1[i1] ? arr0[i0++] : arr1[i1++];
    }
    int[] rem = arr0;
    int remIndex = i0;
    if (i1 < len1) {
      rem = arr1;
      remIndex = i1;
    }
    while (remIndex < rem.length) {
      res[rI++] = rem[remIndex++];
    }
    return res;
  }
}
