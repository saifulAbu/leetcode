package leetcode;

import z_trash.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderPreOrderTraversal_105 {
  private HashMap<Integer, Integer> map = new HashMap<>();
  private int[] inOrder, preOrder;
  //we need to use global variable so that after right tree is consturcted
  //we can start from correct index of left sub tree
  private int postIdx = 0;

  public z_trash.TreeNode buildTree(int[] preOrder, int[] inorder) {
    this.inOrder = inorder;
    this.preOrder = preOrder;
    for(int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return helper(0, inorder.length - 1);
  }

  private z_trash.TreeNode helper(int left, int right) {
    if(postIdx >= this.preOrder.length || left > right) {
      return null;
    }
    int rootVal = preOrder[postIdx];
    int rootIdx = map.get(rootVal);
    z_trash.TreeNode root = new TreeNode(rootVal);

    postIdx++;
    root.left = helper(left, rootIdx - 1);
    root.right = helper(rootIdx + 1, right);


    return root;
  }
}
