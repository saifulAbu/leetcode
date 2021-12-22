package linkedlist;

public class FlattenMultiLevel_430 {
  public Node flatten(Node head) {
    if (head == null) {
      return null;
    }
    return helper(head);
  }

  private Node helper(Node head) {
    Node cur = head;
    while (cur != null) {
      if (cur.child != null) {
        Node flattenedChild = helper(cur.child);
        Node fltnTail = flattenedChild;
        while (fltnTail.next != null) {
          fltnTail = fltnTail.next;
        }
        Node next = cur.next;
        cur.next = flattenedChild;
        cur.child = null;
        flattenedChild.prev = cur;
        fltnTail.next = next;
        if (next != null) {
          next.prev = fltnTail;
        }
        cur = next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
