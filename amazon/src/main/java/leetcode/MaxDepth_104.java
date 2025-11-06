package leetcode;

public class MaxDepth_104 {

  public int maxDepth(TreeNode curNode) {
    if(curNode == null) {
      return 0;
    }
    TreeNode l = curNode.left, r = curNode.right;

    if(l == null && r == null) {
      return 1;
    }

    return Math.max(maxDepth(l), maxDepth(r)) + 1;
  }



  public int maxDepth_01(TreeNode curNode) {
    if(curNode == null) {
      return 0;
    }
    return Math.max(maxDepth_01(curNode.left), maxDepth_01(curNode.right)) + 1;
  }

  ////
  public int maxDepth0(TreeNode root) {
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
