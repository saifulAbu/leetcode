package leetcode;

import z_trash.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreOrder_144 {

  public List<Integer> preorderTraversal(z_trash.TreeNode root) {
    Stack<z_trash.TreeNode> stack = new Stack<>();
    List<Integer> preList = new LinkedList<>();

    if(root != null) {
      stack.push(root);
    }

    while(!stack.isEmpty()) {
      z_trash.TreeNode cur = stack.pop();
      preList.add(cur.val);
      if(cur.right != null) {
        stack.push(cur.right);
      }

      if(cur.left != null) {
        stack.push(cur.left);
      }
    }

    return preList;
  }

  public List<Integer> preorderTraversal1(z_trash.TreeNode root) {
    List<Integer> preOrderList = new LinkedList<>();
    if(isNotNull(root)) {
      preorderTraversal(root, preOrderList);
    }
    return preOrderList;
  }

  private boolean hasLeftChild(z_trash.TreeNode node) {
    return isNotNull(node.left);
  }

  private boolean hasRightChild(z_trash.TreeNode node) {
    return isNotNull(node.right);
  }

  private boolean isNotNull(z_trash.TreeNode node) {
    return node != null;
  }

  //curNode should not be null
  public void preorderTraversal(z_trash.TreeNode curNode, List<Integer> preOrderList) {
    preOrderList.add(curNode.val);

    if(hasLeftChild(curNode)) {
      preorderTraversal(curNode.left, preOrderList);
    }

    if(hasRightChild(curNode)) {
      preorderTraversal(curNode.right, preOrderList);
    }
  }
}

class BinaryTreePreOrder_0_144 {
  public List<Integer> preorderTraversal(z_trash.TreeNode root) {
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
