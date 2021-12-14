package trees_and_graphs;

public class ConvertSortedArray_108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return sortedBSTHelper(0, nums.length - 1, nums);
  }

  private TreeNode sortedBSTHelper(int left, int right, int[] vals) {
    if(left > right) {
      return null;
    }
    int middle = left + (right - left) / 2;
    TreeNode r = new TreeNode(vals[middle]);
    r.left = sortedBSTHelper(left, middle - 1, vals);
    r.right = sortedBSTHelper(middle + 1, right, vals);
    return r;
  }
}
