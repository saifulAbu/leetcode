package contest;
class TreeNode  {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
};

public class WalmartInterview {


  public TreeNode findCommonRoot(TreeNode node0, TreeNode node1, TreeNode root) {
    if (root == null) {
      return null;
    }
    return findCommonRootHelper(node0.val, node1.val, root);
  }

  private TreeNode findCommonRootHelper(int min, int max, TreeNode root) {
    if (min <= root.val && root.val <= max) {
      return root;
    } else if (root.right != null && min > root.val) { // 2 > 8
      return findCommonRootHelper(min, max, root.right);
    } else if(root.left != null) {
      return findCommonRootHelper(min, max, root.left);
    }
    return null;
  }
}

/**
 *
 *          8
 *         3
 *       2   5
 *     1   4  7
 [1, 4]
     3
   2  5
 1   4

 [4, 7]

    5
 4     7
 */
