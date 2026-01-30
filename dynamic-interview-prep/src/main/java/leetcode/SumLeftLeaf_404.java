package leetcode;

public class SumLeftLeaf_404 {
  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    return helper(root, 0);
  }

  private int helper(TreeNode root, int sum) {
    if (root.left != null) {
      if (isLeafNode(root.left)) {
        sum += root.left.val;
      } else {
        sum = helper(root.left, sum);
      }
    }

    if (root.right != null) {
      sum = helper(root.right, sum);
    }
    return sum;
  }

  private boolean isLeafNode(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}
