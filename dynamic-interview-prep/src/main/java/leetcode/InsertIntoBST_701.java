package leetcode;



public class InsertIntoBST_701 {
  public TreeNode insertIntoBST(TreeNode curNode, int val) {
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
