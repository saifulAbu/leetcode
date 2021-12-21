package linkedlist;

public class RemoveNthNode_19 {
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode front, back;
    front = dummy;

    for (int i = 0; i < n + 1; i++) {
      front = front.next;
    }

    back = dummy;
    while (front != null) {
      front = front.next;
      back = back.next;
    }
    back.next = back.next.next;
    return dummy.next;
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    int size = 0;

    ListNode h = dummy.next;
    while (h != null) {
      size++;
      h = h.next;
    }

    if (size == 0) {
      return null;
    }

    ListNode front = dummy;
    for (int i = 0; i < (size - n); i++) {
      front = front.next;
    }
    front.next = front.next.next;
    return dummy.next;
  }
}
