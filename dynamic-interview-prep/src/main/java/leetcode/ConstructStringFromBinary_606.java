package leetcode;

public class ConstructStringFromBinary_606 {
  public String tree2str(TreeNode root) {
    if (root == null) return "";
    return helper(root);
  }

  private String helper(TreeNode root) {
    String res = "" + root.val;
    if (root.left == null && root.right == null) {
      return res;
    } else if (root.left != null && root.right != null){
      return  res + "(" + helper(root.left) + ")" + "(" + helper(root.right) +")";
    } else if (root.left != null) {
      return  res + "(" + helper(root.left) + ")";
    } else {
      return  res + "()" + "(" + helper(root.right) +")";
    }
  }
}
