package leetcode;

import z_trash.TreeNode;

public class IncreasingOrderSearchTree_897 {
  public z_trash.TreeNode increasingBST(z_trash.TreeNode root) {
    z_trash.TreeNode dummyHead = new z_trash.TreeNode(-1);
    rightTreeHelper(root, dummyHead);
    return dummyHead.right;
  }

  private z_trash.TreeNode rightTreeHelper(z_trash.TreeNode curRoot, z_trash.TreeNode resRoot) {
    if(curRoot == null) {
      return resRoot;
    }
    if(curRoot.left != null) {
      resRoot = rightTreeHelper(curRoot.left, resRoot);
    }
    resRoot.right = new TreeNode(curRoot.val);
    return rightTreeHelper(curRoot.right, resRoot.right);
  }
}
