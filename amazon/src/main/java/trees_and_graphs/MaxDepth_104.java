package trees_and_graphs;

public class MaxDepth_104 {
  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return helper(root);
  }

  private int helper(TreeNode root) {
    if(root.left == null && root.right == null) {
      return 0;
    }
    int leftDepth, rightDepth;
    leftDepth = rightDepth = 0;
    if(root.left != null) {
      leftDepth = helper(root.left);
    }
    if(root.right != null) {
      rightDepth = helper(root.right);
    }
    return Integer.max(leftDepth, rightDepth) + 1;
  }
}
