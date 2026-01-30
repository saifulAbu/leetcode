package leetcode;

public class ValidateBinarySearchTree_98 {

  public boolean isValidBST(TreeNode root) {
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

  public static void main(String args[]) {
    ValidateBinarySearchTree_98 vbt = new ValidateBinarySearchTree_98();

    TreeNode n1, n2, n3, n4, n5, n6;
    n1 = new TreeNode(1);
    n2 = new TreeNode(2);
    n3 = new TreeNode(3);
    n4 = new TreeNode(4);
    n5 = new TreeNode(5);
    n6 = new TreeNode(2147483647);
    n6 = new TreeNode(0);

    n4.left = n1;
    n4.right = n5;
    //n5.left = n3;
    n5.right = n6;


    System.out.println(vbt.isValidBST(n6));
  }
}



