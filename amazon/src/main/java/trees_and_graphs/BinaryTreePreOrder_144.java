package trees_and_graphs;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreOrder_144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    if(root != null)
      helper(root, list);
    return list;
  }

  private void helper(TreeNode root, List<Integer> list) {
    list.add(root.val);
    if(root.left != null) {
      helper(root.left, list);
    }
    if(root.right != null) {
      helper(root.right, list);
    }
  }
}
