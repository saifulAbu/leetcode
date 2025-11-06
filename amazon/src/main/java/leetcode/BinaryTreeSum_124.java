package leetcode;

import z_trash.TreeNode;

public class BinaryTreeSum_124 {
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(z_trash.TreeNode root) {
    int throughRoot = helper(root);
    return Math.max(maxSum, throughRoot);
  }

  private int helper(z_trash.TreeNode root) {
    int leftMax = 0, rightMax = 0;
    if(root.left != null) {
      leftMax = Math.max(helper(root.left), 0);
    }
    if(root.right != null) {
      rightMax = Math.max(helper(root.right), 0);
    }
    int oneSided, through;
    oneSided = root.val + Math.max(leftMax, rightMax);
    through = root.val + leftMax + rightMax;
    int curMaxSum = Math.max(oneSided, through);
    if(curMaxSum > maxSum) {
      maxSum = curMaxSum;
    }
    return oneSided;
  }

  public static void main(String args[]) {
    z_trash.TreeNode n0 = new z_trash.TreeNode(2);

    z_trash.TreeNode n1 = new z_trash.TreeNode(2);
    z_trash.TreeNode n2 = new z_trash.TreeNode(2);

    z_trash.TreeNode n3 = new z_trash.TreeNode(-1);
    z_trash.TreeNode n4 = new z_trash.TreeNode(-2);
    z_trash.TreeNode n5 = new z_trash.TreeNode(-1);
    z_trash.TreeNode n6 = new TreeNode(-2);

    n0.left = n1;
    n0.right = n2;

    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    n2.right = n6;

    BinaryTreeSum_124 bts = new BinaryTreeSum_124();
    System.out.println(bts.maxPathSum(n0));
  }
}
