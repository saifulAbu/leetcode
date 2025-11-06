package leetcode;

import z_trash.TreeNode;

public class CountUnivalueSubtrees_250 {
  private int count = 0;
  public int countUnivalSubtrees(z_trash.TreeNode root) {
    if(root != null) {
      isUniValue(root);
    }
    return count;
  }

  private boolean isUniValue(TreeNode root) {
    boolean isUniValue = true;
    if(root.left != null) {
      isUniValue = (isUniValue(root.left)) && (root.val == root.left.val) && isUniValue;
    }
    if(root.right != null) {
      isUniValue = (isUniValue(root.right)) && isUniValue && (root.val == root.right.val);
    }
    if (isUniValue) {
      count++;
      return true;
    }
    return false;
  }
}
