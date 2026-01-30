package linkedlist;

/*
* for linked list problems, it is beneficial to create a dummyHead = new ListNode(0, head);
* saves special cases for null and makes solution easier
* */

public class RemoveNthNode_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyHead = new ListNode(Integer.MIN_VALUE, head);

    //skip forward n steps
    ListNode front = head;
    for(int i = 0; i < n; i++) {
      front = front.next;
    }

    // find the targeted parent node to remove target node
    ListNode targetParent = dummyHead;
    while(front != null) {
      front = front.next;
      targetParent = targetParent.next;
    }

    //remove the node
    ListNode deleteNode = targetParent.next;
    targetParent.next = deleteNode.next;
    return dummyHead.next;
  }

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

  public ListNode removeNthFromEnd0(ListNode head, int n) {
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
