package alpha_rep;

public class SubtreeOfAnotherTree_572 {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if(root == null && subRoot == null) {
      return true;
    }

    if(root == null || subRoot == null) {
      return false;
    }

    return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode r0, TreeNode r1) {
    if(r0 == null && r1 == null) {
      return true;
    }

    if(r0 == null || r1 == null || r0.val != r1.val) {
      return false;
    }

    return isSameTree(r0.left, r1.left) && isSameTree(r0.right, r1.right);
  }

  public boolean isSubtree_drona(TreeNode root, TreeNode subRoot) {
    if (root == null) return false;
    if (isSameTree_drona(root, subRoot)) return true;
    return isSubtree_drona(root.left, subRoot) || isSubtree_drona(root.right, subRoot);
  }

  private boolean isSameTree_drona(TreeNode a, TreeNode b) {
    if (a == null && b == null) return true;
    if (a == null || b == null || a.val != b.val) return false;
    return isSameTree_drona(a.left, b.left) && isSameTree_drona(a.right, b.right);
  }

}
