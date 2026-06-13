package alpha_rep;

public class BinaryTreeSum_124 {
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    int throughRoot = helper(root);
    return Math.max(maxSum, throughRoot);
  }

  private int helper(TreeNode root) {
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

  private int max_drona = Integer.MIN_VALUE;

  public int maxPathSum_drona(TreeNode root) {
    maxGain_drona(root);
    return max_drona;
  }

  private int maxGain_drona(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftGain = Math.max(0, maxGain_drona(root.left));
    int rightGain = Math.max(0, maxGain_drona(root.right));

    int curGain = root.val + leftGain + rightGain;

    max_drona = Math.max(max_drona, curGain);

    return root.val + Math.max(leftGain, rightGain);
  }
}
