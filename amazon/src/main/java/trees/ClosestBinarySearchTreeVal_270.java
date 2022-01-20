package trees;

import trees_and_graphs.TreeNode;

public class ClosestBinarySearchTreeVal_270 {
  public static class TreeNode {
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

  public int closestValue(TreeNode root, double target) {
    int left = Integer.MIN_VALUE;
    int right = Integer.MAX_VALUE;

    if (root.left != null) {
      left = closestValue(root.left, target);
    }

    if (root.right != null) {
      right = closestValue(root.right, target);
    }

    double leftAbs =  Math.abs(left - target);
    double rightAbs = Math.abs(right - target);
    double curAbs = Math.abs(root.val - target);

    if (curAbs < leftAbs && curAbs < rightAbs) {
      return root.val;
    } else if (leftAbs < rightAbs) {
      return left;
    } else {
      return right;
    }
  }
}
