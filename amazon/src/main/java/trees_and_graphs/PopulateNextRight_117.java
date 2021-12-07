package trees_and_graphs;

import java.util.LinkedList;

public class PopulateNextRight_117 {
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
