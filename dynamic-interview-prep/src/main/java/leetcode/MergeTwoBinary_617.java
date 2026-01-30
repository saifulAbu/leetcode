package leetcode;

public class MergeTwoBinary_617 {
  public TreeNode mergeTrees(TreeNode root0, TreeNode root1) {
    if (root0 == null && root1 == null) {
      return null;
    }
    TreeNode r = new TreeNode(0);
    TreeNode l0, l1, r0, r1;
    l0 = l1 = r0 = r1 = null;

    if(root0 != null) {
      l0 = root0.left;
      r0 = root0.right;
      r.val += root0.val;
    }

    if(root1 != null) {
      l1 = root1.left;
      r1 = root1.right;
      r.val += root1.val;
    }

    r.left = mergeTrees(l0, l1);
    r.right = mergeTrees(r0, r1);

    return r;
  }
}
