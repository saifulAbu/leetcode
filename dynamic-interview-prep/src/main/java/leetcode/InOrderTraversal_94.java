package leetcode;



import java.util.*;

public class InOrderTraversal_94 {
  // solving the problem in more interesting iterative way
  // leetcode website says recursive way to solve this problem is trivial
  public List<Integer> inorderTraversal(TreeNode root) {
    HashSet<TreeNode> bothChildDiscovered = new HashSet<>();
    List<Integer> inorderList = new LinkedList<>();

    if(root == null) {
     return inorderList;
    }

    Stack<TreeNode> nodeStack = new Stack<>();
    nodeStack.push(root);

    while(!nodeStack.isEmpty()) {
      TreeNode curNode = nodeStack.pop();
      if(bothChildDiscovered.contains(curNode)) {
        inorderList.add(curNode.val);
      } else {
        // we will add nodes in reverse order in stack
        // because stack is first in first out
        //       curNode
        //     /        \
        //   left      right
        // stack : [right, curNode, left, ...
        if(curNode.right != null) {
          nodeStack.push(curNode.right);
        }
        nodeStack.push(curNode);
        if(curNode.left != null) {
          nodeStack.push(curNode.left);
        }
        bothChildDiscovered.add(curNode);
      }
    }
    return inorderList;
  }

    /**/
  List<Integer> inorderList = new LinkedList<>();

  public List<Integer> inorderTraversal1(TreeNode root) {
    // check basic case
    if(root != null) {
      fillInorderList(root);
    }
    return inorderList;
  }

  //root is always not null
  private void fillInorderList(TreeNode curNode) {
    // travel left
    if(curNode.left != null) {
      fillInorderList(curNode.left);
    }
    // travel this
    inorderList.add(curNode.val);
    //travel right
    if(curNode.right != null) {
      fillInorderList(curNode.right);
    }
  }

  public List<Integer> inorderTraversal0(TreeNode root) {
    List<Integer> r = new ArrayList<>();
    inorderTraversalHelper(root, r);
    return r;
  }

  private void inorderTraversalHelper(TreeNode root, List<Integer> l) {
    if(root == null) {
      return;
    }
    inorderTraversalHelper(root.left, l);
    l.add(root.val);
    inorderTraversalHelper(root.right, l);
  }
}
