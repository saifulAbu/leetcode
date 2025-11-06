package leetcode;

import z_trash.TreeNode;

public class IsSameTree_100 {
  public boolean isSameTree(z_trash.TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    }
    if(p == null || q == null ) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
