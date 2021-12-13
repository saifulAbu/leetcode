package linkedlist;

public class ReverseLinkedList_206 {
  public ListNode reverseList(ListNode head) {
    ListNode result, dummy;
    result = new ListNode(0);
    dummy = new ListNode(0);
    dummy.next = head;

    while (dummy.next != null) {
      ListNode cur = dummy.next;
      dummy.next = cur.next;
      cur.next = result.next;
      result.next = cur;
    }

    return result.next;
  }
}
