package leetcode;

import z_trash.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal_145 {
  public List<Integer> postorderTraversal(z_trash.TreeNode root) {
    List<Integer> r = new ArrayList<>();
    postOrderTraversalHelper(root, r);
    return r;
  }

  private void postOrderTraversalHelper(z_trash.TreeNode root, List<Integer> l) {
    if(root == null) {
      return;
    }
    postOrderTraversalHelper(root.left, l);
    postOrderTraversalHelper(root.right, l);
    l.add(root.val);
  }

  public static void main(String args[]) {
    PostOrderTraversal_145 iot = new PostOrderTraversal_145();
    z_trash.TreeNode n1 = new z_trash.TreeNode(1);
    z_trash.TreeNode n2 = new z_trash.TreeNode(2);
    z_trash.TreeNode n3 = new TreeNode(3);

    n1.left = null;
    n1.right = n2;
    n2.left = n3;
    n2.right = null;

    List<Integer> r = iot.postorderTraversal(n1);
    System.out.println(r);
  }
}
