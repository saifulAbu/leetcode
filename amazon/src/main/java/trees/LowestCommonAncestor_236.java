package trees;

public class LowestCommonAncestor_236 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q) {
      return root;
    }
    if (root.left == null && root.right == null) {
      return null;
    }

    if (root.left == null && root.right != null) {
      return lowestCommonAncestor(root.right, p, q);
    }

    if (root.right == null && root.left != null) {
      return lowestCommonAncestor(root.left, p, q);
    }

    boolean foundOnLeft = false, foundOnRight = false;

    foundOnLeft = find(root.left, p);
    foundOnRight = !foundOnLeft;

    if (foundOnRight) {
      foundOnLeft = find(root.left, q);
    } else {
      foundOnRight = find(root.right, q);
    }
    if(foundOnLeft && foundOnRight) {
      return root;
    }
    if (foundOnLeft) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }

  boolean find(TreeNode root, TreeNode node) {
    if (root == node) {
      return true;
    }
    if((root.left != null && find(root.left, node)) || (root.right != null && find(root.right, node))) {
      return true;
    }
    return false;
  }
}
