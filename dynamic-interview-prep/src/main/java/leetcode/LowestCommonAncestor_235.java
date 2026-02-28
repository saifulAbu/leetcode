package leetcode;

public class LowestCommonAncestor_235 {

  public TreeNode lowestCommonAncestor_drona(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;  // covers: root==p, root==q, or p and q on different sides
    }
  }

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


  public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
    if(root == p || root == q || (p.val < root.val && root.val < q.val ) || (q.val < root.val && root.val < p.val)) {
      return root;
    }
    return root.val < p.val ? lowestCommonAncestor_1(root.right, p, q) : lowestCommonAncestor_1(root.left, p, q) ;
  }
}
