package trees_and_graphs;

public class IncreasingOrderSearchTree_897 {
  public TreeNode increasingBST(TreeNode root) {
    TreeNode dummyHead = new TreeNode(-1);
    rightTreeHelper(root, dummyHead);
    return dummyHead.right;
  }

  private TreeNode rightTreeHelper(TreeNode curRoot, TreeNode resRoot) {
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
