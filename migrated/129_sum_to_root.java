package com.company;

public class SumRootToLeaf {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int sumNumbers(TreeNode root) {
    return sumNumbersHelper(root, 0);
  }

  public int sumNumbersHelper(TreeNode root, int num) {
    num = num * 10 + root.val;
    if(root.left == null && root.right == null) {
      return num;
    }
    int sum = 0;
    if(root.left != null) {
      sum += sumNumbersHelper(root.left, num);
    }
    if(root.right != null) {
      sum += sumNumbersHelper(root.right, num);
    }
    return sum;
  }
}