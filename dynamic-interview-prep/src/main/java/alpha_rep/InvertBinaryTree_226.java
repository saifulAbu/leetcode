package alpha_rep;

public class InvertBinaryTree_226 {
  public TreeNode invertTree_0(TreeNode root) {
    /*
    * we will use a strategy similar to dfs
    * we will invert left and right child
    * if then swap the childs
    *
    * base case is when the node is null
    * */
    if(root == null) {
      return null;
    }

    invertTree_0(root.left);
    invertTree_0(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
  }

  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return null;
    }
    TreeNode left = root.left, right = root.right;
    root.right = invertTree(left);
    root.left = invertTree(right);
    return root;
  }
}
