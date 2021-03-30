package trees_and_graphs;

public class RangeSumBST_938 {
  public int rangeSumBST(TreeNode root, int low, int high) {
    int sum = 0;
    if(root == null) {
      return sum;
    }
    sum = sum + rangeSumBST(root.left, low, high);
    sum = sum + rangeSumBST(root.right, low, high);

    if(low <= root.val && root.val <= high) {
      sum += root.val;
    }
    return sum;
  }
}
