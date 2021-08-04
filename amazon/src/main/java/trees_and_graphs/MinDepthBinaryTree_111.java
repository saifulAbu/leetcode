package trees_and_graphs;

public class MinDepthBinaryTree_111 {
  public int minDepth(TreeNode root) {
      if(root == null) {
        return 0;
      }
    return getNumNode(root);
  }

  private int getNumNode(TreeNode root) {

    if(root.left == null && root.right == null) {
      return 1;
    }
    int left = Integer.MAX_VALUE;
    if(root.left != null) {
      left = getNumNode(root.left);
    }

    int right = Integer.MAX_VALUE;
    if(root.right != null) {
      right = getNumNode(root.right);
    }

    return Math.min(left, right) + 1;
  }
}

// dummy
// keep the wheel moving
// keep the wheel moving