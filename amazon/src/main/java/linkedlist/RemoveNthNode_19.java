package linkedlist;

public class RemoveNthNode_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
