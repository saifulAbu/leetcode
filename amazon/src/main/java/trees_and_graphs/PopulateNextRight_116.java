package trees_and_graphs;

import java.util.LinkedList;

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
};

public class PopulateNextRight_116 {
  public Node connect(Node root) {
    if(root == null) {
      return null;
    }
    LinkedList<Node> q = new LinkedList<>();
    q.offerLast(root);
    while (!q.isEmpty()) {
      int curSize = q.size();
      for (int i = 0; i < curSize; i++) {
        Node cur = q.pollFirst();
        Node next = q.peekFirst();
        if (i < curSize - 1) {
          cur.next = next;
        }
        if (cur.left != null) {
          q.offerLast(cur.left);
        }
        if (cur.right != null) {
          q.offerLast(cur.right);
        }
      }
    }
    return root;
  }
}
