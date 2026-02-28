package alpha_rep;

public class ValidateBinarySearchTree_98 {

  public boolean isValidBST(TreeNode root) {
    /**
     * Integer.MIN_Value is a valid node value so it we need to use long instead
     *
     */
    return isValidHelper_2_9(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidHelper_2_9(TreeNode root, Long min, Long max) {
    if(root == null) {
      return true;
    }
    return root.val >= min && root.val <= max && isValidHelper_2_9(root.left, min,  (long)root.val - 1) && isValidHelper_2_9(root.right, (long)root.val + 1, max);
  }

  public boolean isValidBST_1(TreeNode root) {
    return isValidBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean isValidBST1(TreeNode curNode, int leftLimit, int rightLimit) {
    if(curNode == null) {
      return true;
    }

    int curVal = curNode.val;
    //basic check
    if (leftLimit >= curVal || curVal >= rightLimit) {
      return false;
    }

    return isValidBST1(curNode.left, leftLimit, curVal) && isValidBST1(curNode.right, curVal, rightLimit);
  }

  public boolean isValidBST0(TreeNode root) {
    return isValidBST_helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean isValidBST_helper(TreeNode root, long lowerLimit, long upperLimit) {
    if(root.val > lowerLimit && root.val < upperLimit) {
      if(root.left != null) {
        if(!isValidBST_helper(root.left, lowerLimit, root.val)) {
          return false;
        }
      }
      if(root.right != null) {
        if(!isValidBST_helper(root.right, root.val, upperLimit)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public boolean isValidBST_2(TreeNode root) {
    return isValidBST_helper_2_28(root, (long)(Integer.MIN_VALUE) - 1, (long)(Integer.MAX_VALUE) + 1);
  }

  boolean isValidBST_helper_2_28(TreeNode root, long l, long h) {
    if(root == null) return true;
    return (l < root.val && root.val < h && isValidBST_helper_2_28(root.left, l, root.val) && isValidBST_helper_2_28(root.right, root.val, h));
  }

}



