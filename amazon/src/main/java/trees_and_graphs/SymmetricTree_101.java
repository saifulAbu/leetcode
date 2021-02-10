package trees_and_graphs;

public class SymmetricTree_101 {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;
    return helperSymmetric(root.left, root.right);
  }

  private boolean helperSymmetric(TreeNode left, TreeNode right) {
    if(left == null && right == null) {
      return true;
    }

    if((left == null && right != null) || (left != null && right == null)) {
      return false;
    }

    if(left.val != right.val) {
      return false;
    }

    if(helperSymmetric(left.left, right.right)){
      return helperSymmetric(left.right, right.left);
    }

    return false;
  }

  public static void main(String args[]) {
    TreeNode n0 = new TreeNode(1);

    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(2);

    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(4);
    TreeNode n6 = new TreeNode(3);

    n0.left = n1;
    n0.right = n2;

    n1.left = n3;
    n1.right = n4;
    n2.left = n5;
    //n2.right = n6;

    SymmetricTree_101 st = new SymmetricTree_101();
    System.out.println(st.isSymmetric(n0));
  }
}

