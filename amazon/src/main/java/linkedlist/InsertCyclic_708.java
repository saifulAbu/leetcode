package linkedlist;

public class InsertCyclic_708 {
  private static class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  };

  public Node insert(Node head, int insertVal) {
    Node n = new Node(insertVal);
    if (head == null) {
      n.next = n;
      return n;
    }
    // one element case
    if (head.next == head) {
      n.next = head;
      head.next = n;
      return  head;
    }
    Node prev = head, cur = head.next;
    do {
      if ((prev.val <= insertVal && cur.val >= insertVal) ||
          (prev.val > cur.val && (insertVal > prev.val || insertVal < cur.val))) {
        break;
      }
      prev = cur;
      cur = cur.next;
    }while (prev != head);

    prev.next = n;
    n.next = cur;
    return head;
  }
}

