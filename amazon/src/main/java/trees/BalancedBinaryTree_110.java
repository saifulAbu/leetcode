package trees;

public class BalancedBinaryTree_110 {
  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() { }
    TreeNode(int val) {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  };

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
