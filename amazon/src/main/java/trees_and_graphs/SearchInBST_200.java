package trees_and_graphs;

public class SearchInBST_200 {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || root.val == val)
      return root;

    return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
  }
}
