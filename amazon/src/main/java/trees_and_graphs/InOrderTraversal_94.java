package trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal_94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> r = new ArrayList<>();
    inorderTraversalHelper(root, r);
    return r;
  }

  private void inorderTraversalHelper(TreeNode root, List<Integer> l) {
    if(root == null) {
      return;
    }
    inorderTraversalHelper(root.left, l);
    l.add(root.val);
    inorderTraversalHelper(root.right, l);
  }

  public static void main(String args[]) {
    InOrderTraversal_94 iot = new InOrderTraversal_94();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);

    n1.left = null;
    n1.right = n2;
    n2.left = n3;
    n2.right = null;

    List<Integer> r = iot.inorderTraversal(n1);
    System.out.println(r);
  }
}
