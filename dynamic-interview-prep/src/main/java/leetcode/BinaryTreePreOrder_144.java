package leetcode;



import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BinaryTreePreOrder_144 {

  public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> preList = new LinkedList<>();

    if(root != null) {
      stack.push(root);
    }

    while(!stack.isEmpty()) {
      TreeNode cur = stack.pop();
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

  public List<Integer> preorderTraversal1(TreeNode root) {
    List<Integer> preOrderList = new LinkedList<>();
    if(isNotNull(root)) {
      preorderTraversal(root, preOrderList);
    }
    return preOrderList;
  }

  private boolean hasLeftChild(TreeNode node) {
    return isNotNull(node.left);
  }

  private boolean hasRightChild(TreeNode node) {
    return isNotNull(node.right);
  }

  private boolean isNotNull(TreeNode node) {
    return node != null;
  }

  //curNode should not be null
  public void preorderTraversal(TreeNode curNode, List<Integer> preOrderList) {
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
  public List<Integer> preorderTraversal(TreeNode root) {
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
