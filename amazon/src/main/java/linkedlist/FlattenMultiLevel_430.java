package linkedlist;

public class FlattenMultiLevel_430 {
  private  static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  };

  public Node flatten(Node head) {
    if(head == null) {
      return head;
    }
    getFlattenedNodeTail(head);
    return head;
  }

  // returns tail of the flattened list
  // h is guaranteed to be not null
  private Node getFlattenedNodeTail(Node h) {
    Node tail = h;

    while(h != null) {
      Node cur = h, childHead = cur.child;
      h = h.next;

      if(childHead != null) {
        Node childTail = getFlattenedNodeTail(childHead);
        cur.next = childHead;
        childHead.prev = cur;
        cur.child = null;
        childTail.next = h;

        if(h != null) {
          h.prev = childTail;
        } else {
          tail = childTail;
          break;
        }
      } else {
        if(h == null) {
          tail = cur;
          break;
        }
      }
    }

    return tail;
  }

  public Node flatten0(Node head) {
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
