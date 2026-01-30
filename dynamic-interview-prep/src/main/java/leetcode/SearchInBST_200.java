package leetcode;



public class SearchInBST_200 {
  public TreeNode searchBST(TreeNode curNode, int val) {
    if(curNode == null || curNode.val == val) {
      return curNode;
    }

    return curNode.val > val ? searchBST(curNode.left, val) : searchBST(curNode.right, val);
  }

  public TreeNode searchBST0(TreeNode root, int val) {
    if (root == null || root.val == val)
      return root;

    return root.val > val ? searchBST0(root.left, val) : searchBST0(root.right, val);
  }
}
