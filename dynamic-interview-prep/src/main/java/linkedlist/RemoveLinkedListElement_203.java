package linkedlist;

/*
* cases to consider.
* 0: 1 - 1 - 1 - 1 , val = 1
* 1: 1 - 2- 3 - 4 , val = 5
* 2: 1 - 2 - 3 - 4 - 5 , val = 3
* 3: 1 , val = 1
* */

public class RemoveLinkedListElement_203 {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0, head), parent = dummyHead;
    while(parent != null) {
      ListNode child = parent.next;
      if(child == null) {
        break;
      }
      if(child.val == val) {
        parent.next = child.next;
      } else {
        // for case 0, we don't want to move the parent on each iteration
        // only move parent if the child node has value != val
        parent = parent.next;
      }
    }
    return dummyHead.next;
  }

  public ListNode removeElements0(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    while (prev.next != null) {
      if (prev.next.val == val) {
        prev.next = prev.next.next;
      } else {
        prev = prev.next;
      }
    }
    return dummy.next;
  }
}
