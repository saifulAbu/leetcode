package alpha_rep;

public class InsertIntoBST_701 {

  public TreeNode insertIntoBST(TreeNode curNode, int val) {
    /*
    * if curNode == null
    *   return new TreeNode(val)
    * if (curNode.val < val)
    *   curNode.right = insertIntoBST(curNode.left, val) // we are doing this in case right is null, we want to update the tree
    * ... so on
    * */

    if(curNode == null) {
      return new TreeNode(val);
    }

    if(curNode.val < val) {
      curNode.right = insertIntoBST(curNode.right, val);
    } else {
      curNode.left = insertIntoBST(curNode.left, val);
    }
    return curNode;
  }

  public TreeNode insertIntoBST_0(TreeNode curNode, int val) {
    if(curNode == null) {
      return new TreeNode(val);
    }

    int curVal = curNode.val;
    if(curVal > val) {
      curNode.left = insertIntoBST(curNode.left, val);
    } else {
      curNode.right = insertIntoBST(curNode.right, val);
    }

    return curNode;
  }
}
