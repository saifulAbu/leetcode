package leetcode;

import z_trash.TreeNode;

public class SameTree_100 {

  public boolean isSameTree(z_trash.TreeNode p, TreeNode q) {
      if(p == null && q == null) {
        return true;
      }

      if(p == null || q == null) {
        return false;
      }

      if(p.val != q.val || !(isSameTree(p.left, q.left))) {
        return false;
      }

      return isSameTree(p.right, q.right);
  }
}

// dummy
// more dummy :)
// one more
// one more
//one more
