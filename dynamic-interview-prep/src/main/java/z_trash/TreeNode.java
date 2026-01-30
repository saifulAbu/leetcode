package z_trash;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
  
  private void exampleUsage() {
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
      n2.right = n6;
  }
}
