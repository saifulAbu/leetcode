package leetcode;

import z_trash.TreeNode;

public class SearchInBST_200 {
  public z_trash.TreeNode searchBST(z_trash.TreeNode curNode, int val) {
    if(curNode == null || curNode.val == val) {
      return curNode;
    }

    return curNode.val > val ? searchBST(curNode.left, val) : searchBST(curNode.right, val);
  }

  public z_trash.TreeNode searchBST0(TreeNode root, int val) {
    if (root == null || root.val == val)
      return root;

    return root.val > val ? searchBST0(root.left, val) : searchBST0(root.right, val);
  }
}
