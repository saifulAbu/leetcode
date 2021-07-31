package trees_and_graphs;

public class BalancedBinaryTree_110 {
  public boolean isBalanced(TreeNode root) {
    int val = getHeight(root);
    if(val == -1) {
      return false;
    }
    return true;
  }

  private int getHeight(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    if (left == -1) {
      return -1;
    }
    int right = getHeight(root.right);
    if (right == -1) {
      return -1;
    }

    if(Math.abs(left - right) > 1) {
      return -1;
    }

    return Math.max(left, right) + 1;
  }
}
