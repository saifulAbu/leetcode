package alpha_rep;

class BST {

  class TreeNode {
    int s0, e0;
    TreeNode left, right;

    public TreeNode(int startTime, int endTime) {
      this.s0 = startTime;
      this.e0 = endTime;
    }
  }

  TreeNode root;

  public boolean canInsert(int s1, int e1) {
    return canInsertHelper(root, s1, e1);
  }

  private boolean canInsertHelper(TreeNode root, int s1, int e1) {
    /*
     *  [10, 20]
     * if a new entry comes [9, 10] we should add e1 <= s0 -- to left
     * if a new entry comes [20, 25] we should add e0 <= s1 -- to right
     * if a new entry comes [15, 18] we should reject it because it does not fit the above 2 criteria
     *
     * we can maitain a tree with this criteria
     * */

    if(root == null) {
      return true;
    }
    if(e1 <= root.s0) {
      return canInsertHelper(root.left, s1, e1);
    } else if (root.e0 <= s1) {
      return canInsertHelper(root.right, s1, e1);
    }
    return false;
  }

  public TreeNode insert(int s1, int e1) {
    if(root == null) {
      root = new TreeNode(s1, e1);
      return root;
    }

    if(canInsertHelper(root, s1, e1)) {
      return insertHelper(root, s1, e1);
    }
    return null;
  }

  TreeNode insertHelper(TreeNode root, int s1, int e1) {
    if(root == null) {
      return new TreeNode(s1, e1);
    }
    if(e1 <= root.s0) {
      root.left = insertHelper(root.left, s1, e1);
    } else if (root.e0 <= s1) {
      root.right =  insertHelper(root.right, s1, e1);
    }
    return root;
  }
}

public class MyCalendar_729 {

  BST bst = new BST();

  public boolean book(int s1, int e1) {
    if(bst.canInsert(s1, e1)) {
      bst.insert(s1, e1);
      return true;
    }
    return false;
  }

}
