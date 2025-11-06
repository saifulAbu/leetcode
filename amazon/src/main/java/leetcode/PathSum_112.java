package leetcode;

public class PathSum_112 {

  public boolean hasPathSum(TreeNode curNode, int targetSum) {
    if(curNode == null) {
      return false;
    }
    return hasPathSumHelper02(curNode, targetSum);
  }
  public boolean hasPathSumHelper02(TreeNode curNode, int targetSum) {
    if(curNode == null) {
      if(targetSum == 0) {
        return true;
      } else {
        return false;
      }
    }

    int remainingSum = targetSum - curNode.val;
    return hasPathSumHelper02(curNode.left, remainingSum) || hasPathSumHelper02(curNode.right, remainingSum);
  }
  
  public boolean hasPathSum_01(TreeNode root, int targetSum) {
    return hasPathSum(root, 0, targetSum);
  }

  private boolean hasPathSum(TreeNode curNode, int sumUptoParent, int targetSum) {
    if(curNode == null) {
      return false;
    }

    int sumUptoCur = sumUptoParent + curNode.val;
    if(curNode.left == null && curNode.right == null) {
      return sumUptoCur == targetSum;
    }

    return hasPathSum(curNode.left, sumUptoCur, targetSum) || hasPathSum(curNode.right, sumUptoCur, targetSum);
  }


  public boolean hasPathSum0(TreeNode root, int targetSum) {
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
