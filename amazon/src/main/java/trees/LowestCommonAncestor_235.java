package trees;

public class LowestCommonAncestor_235 {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  };
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return findCommonRootHelper(Math.min(p.val, q.val), Math.max(p.val, q.val), root);
  }

  private TreeNode findCommonRootHelper(int min, int max, TreeNode root) {
    if (min <= root.val && root.val <= max) {
      return root;
    } else if (root.right != null && min > root.val) { // 2 > 8
      return findCommonRootHelper(min, max, root.right);
    } else if(root.left != null) {
      return findCommonRootHelper(min, max, root.left);
    }
    return null;
  }
}
