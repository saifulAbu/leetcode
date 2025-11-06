package leetcode;

import z_trash.TreeNode;

public class ConvertSortedArray_108 {
  public z_trash.TreeNode sortedArrayToBST(int[] nums) {
    return sortedBSTHelper(0, nums.length - 1, nums);
  }

  private z_trash.TreeNode sortedBSTHelper(int left, int right, int[] vals) {
    if(left > right) {
      return null;
    }
    int middle = left + (right - left) / 2;
    z_trash.TreeNode r = new TreeNode(vals[middle]);
    r.left = sortedBSTHelper(left, middle - 1, vals);
    r.right = sortedBSTHelper(middle + 1, right, vals);
    return r;
  }
}
