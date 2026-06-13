package alpha_rep;

public class KthSmalles_230 {
  private int count = 0;
  private int answer = 0;
  private boolean found = false;

  public int kthSmallest_drona(TreeNode root, int k) {
    inorder_drona(root, k);
    return answer;
  }

  private void inorder_drona(TreeNode node, int k) {
    if (node == null || found) {
      return;
    }

    // LEFT
    inorder_drona(node.left, k);

    // NODE
    count++;
    if (count == k) {
      answer = node.val;
      found = true;
      return;
    }

    // RIGHT
    inorder_drona(node.right, k);
  }
}
