package trees_and_graphs;

public class LowestCommonAncestor_236 {
  private TreeNode p, q;
  private TreeNode ans;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    this.p = p;
    this.q = q;
    if (root == null) {
      return  null;
    }
    find(root);
    return ans;
  }

  private boolean find(TreeNode root) {
    int curNodeIsTarget = 0, foundOnLeft = 0, foundOnRight = 0;

    if (root == p || root == q) {
      curNodeIsTarget = 1;
    }

    if(root.left != null && find(root.left)) {
      foundOnLeft = 1;
    }

    if(root.right != null && find(root.right)) {
      foundOnRight = 1;
    }

    if (foundOnLeft + curNodeIsTarget + foundOnRight == 2) {
      this.ans = root;
    }

    return foundOnLeft + curNodeIsTarget + foundOnRight > 0;
  }
}
