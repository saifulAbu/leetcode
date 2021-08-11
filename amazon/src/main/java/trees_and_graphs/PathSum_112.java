package trees_and_graphs;

public class PathSum_112 {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    return helper(root, targetSum);
  }

  private boolean helper(TreeNode root, int targetSum) {
    targetSum = targetSum - root.val;
    if(root.left == null && root.right == null && targetSum == 0) {
      return true;
    }
    if(root.left != null && helper(root.left, targetSum)) {
      return true;
    }
    if(root.right != null && helper(root.right, targetSum)) {
      return true;
    }
    return false;
  }
}
