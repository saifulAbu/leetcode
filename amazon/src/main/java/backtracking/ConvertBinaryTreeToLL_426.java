package backtracking;

public class ConvertBinaryTreeToLL_426 {
  private static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  };
  /////
  Node head = new Node(Integer.MIN_VALUE);
  Node tail = head;

  public Node treeToDoublyList(Node root) {
    if(root == null) {
      return root;
    }
    helper(root);
    head = head.right;
    head.left = tail;
    tail.right = head;
    return head;
  }

  private void helper(Node cur) {
    if (cur.left != null) {
      helper(cur.left);
    }
    tail.right = cur;
    cur.left = tail;
    tail = cur;
    if (cur.right != null) {
      helper(cur.right);
    }
  }
}
