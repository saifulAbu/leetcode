package trees;

public class CountGoodNodesBinaryTree_1448 {
  public static class TreeNode {
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

  int res = 0;
  public int goodNodes(TreeNode root) {
    helper(root, Integer.MIN_VALUE);
    return res;
  }

  void helper(TreeNode root, int max) {
    if (root.val >= max) {
      res++;
    }
    max = Math.max(root.val, max);
    if (root.left!= null) helper(root.left, max);
    if (root.right!= null) helper(root.right, max);
  }
}
