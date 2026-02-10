package alpha_rep;

public class InvertBinaryTree_226 {
  public TreeNode invertTree(TreeNode root) {
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

    invertTree(root.left);
    invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    return root;
  }
}
