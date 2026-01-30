package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderPostorderTraversal_106 {
  private HashMap<Integer, Integer> map = new HashMap<>();
  private int[] inOrder, postOrder;
  //we need to use global variable so that after right tree is consturcted
  //we can start from correct index of left sub tree
  private int postIdx;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inOrder = inorder;
    this.postOrder = postorder;
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    postIdx = postorder.length - 1;
    return helper(0, inorder.length - 1);
  }

  private TreeNode helper(int left, int right) {
    if(postIdx < 0 || left > right) {
      return null;
    }
    int rootVal = postOrder[postIdx];
    int rootIdx = map.get(rootVal);
    TreeNode root = new TreeNode(rootVal);

    postIdx--;
    root.right = helper(rootIdx + 1, right);
    root.left = helper(left, rootIdx - 1);

    return root;
  }
}
