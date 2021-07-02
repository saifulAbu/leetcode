package linkedlist;

public class RemoveDuplicates_83 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode front = head;
    while(front != null) {
      ListNode back = front.next;
      while(back != null && back.val == front.val) {
        back = back.next;
      }
      front.next = back;
      front = front.next;
    }
    return head;
  }
}
